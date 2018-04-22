package com.code.knab.best_quiz.ui.single_question

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.code.knab.best_quiz.R
import com.code.knab.best_quiz.network.json.Question
import com.code.knab.best_quiz.ui.single_question.dagger.SingleQuestionInjector
import com.code.knab.best_quiz.ui.single_question.mvp.SingleQuestionMVP
import kotlinx.android.synthetic.main.activity_single_question.*
import javax.inject.Inject

class SingleQuestionActivity : AppCompatActivity(), SingleQuestionMVP.View  {
    companion object {

        val PROJECT_KEY = "PROJECT_KEY"

        fun open(activity: Activity, questionId: Int, code: Int){
            Intent(activity, SingleQuestionActivity::class.java).apply {
                this.putExtra(PROJECT_KEY, questionId)
                activity.startActivityForResult(this, code)
            }
        }

    }

    @Inject
    lateinit var presenter: SingleQuestionMVP.Presenter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_question)
        SingleQuestionInjector().inject(this)

        presenter.loadQuestion(intent.getIntExtra(PROJECT_KEY, 0))
    }

    override fun displayQuestion(question: Question) {
        answerOneTextView.text = question.answers[0].content
        answerTwoTextView.text = question.answers[1].content
        answerThreeTextView.text = question.answers[2].content
        answerFourTextView.text = question.answers[3].content
    }

    override fun handleErrorInView() {
        Toast.makeText(this, "There were some problems with http. Please try again later.", Toast.LENGTH_SHORT).show()
    }

    override fun submitCompleted() {
        this.finish()
    }
}
