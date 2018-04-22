package com.code.knab.best_quiz.ui.single_question

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import com.code.knab.best_quiz.R
import com.code.knab.best_quiz.network.json.Question
import com.code.knab.best_quiz.ui.single_question.dagger.SingleQuestionInjector
import com.code.knab.best_quiz.ui.single_question.mvp.SingleQuestionMVP
import kotlinx.android.synthetic.main.activity_single_question.*
import javax.inject.Inject

class SingleQuestionActivity : AppCompatActivity(), SingleQuestionMVP.View {
    companion object {

        val PROJECT_KEY = "PROJECT_KEY"

        fun open(activity: Activity, questionId: Int, code: Int) {
            Intent(activity, SingleQuestionActivity::class.java).apply {
                this.putExtra(PROJECT_KEY, questionId)
                activity.startActivityForResult(this, code)
            }
        }

    }

    @Inject
    lateinit var presenter: SingleQuestionMVP.Presenter

    private var question: Question? = null
    private var selectedAnswerId: Int? = null

    private var answers = listOf<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_question)
        SingleQuestionInjector().inject(this)

        presenter.loadQuestion(intent.getIntExtra(PROJECT_KEY, 0))
        submitAnswerButton.isEnabled = false
        answers = listOf(answerOneTextView, answerTwoTextView, answerThreeTextView, answerFourTextView)
        answers.forEachIndexed { index, view ->
            view.setOnTouchListener { v, event ->  setActive(index); true}
        }
        submitAnswerButton.setOnClickListener {
            selectedAnswerId?.let { presenter.answer(it) }
            submitAnswerButton.isEnabled = false
        }
    }

    override fun displayQuestion(question: Question) {
        questionTextView.text = question.content
        answerOneTextView.text = question.answers[0].content
        answerTwoTextView.text = question.answers[1].content
        answerThreeTextView.text = question.answers[2].content
        answerFourTextView.text = question.answers[3].content
        this.question = question
    }

    private fun setActive(idx: Int) {
        answers.forEachIndexed { index, view ->
            if(index == idx) view.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            else view.setBackgroundColor(resources.getColor(R.color.white))
        }
        submitAnswerButton.isEnabled = true
        selectedAnswerId = question?.answers?.get(idx)?.id
    }

    override fun handleErrorInView() {
        Toast.makeText(this, "There were some problems with http. Please try again later.", Toast.LENGTH_SHORT).show()
        submitAnswerButton.isEnabled = true
    }

    override fun submitCompleted(answeredCorrectly: Boolean) {
        val text = if (answeredCorrectly) "Congrats! Correct answer!" else "Not this time buddy"
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        thread.start()
        this.finish()
    }

    override fun onStop() {
        super.onStop()
        presenter.compositeDisposable.clear()
    }

    var thread: Thread = object : Thread() {
        override fun run() {
            try {
                Thread.sleep(2000) // As I am using LENGTH_LONG in Toast
                this@SingleQuestionActivity.finish()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}
