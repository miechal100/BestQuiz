package com.code.knab.best_quiz.ui.questions

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.code.knab.best_quiz.R
import com.code.knab.best_quiz.network.json.Question
import com.code.knab.best_quiz.ui.questions.dagger.QuestionListInjector
import com.code.knab.best_quiz.ui.questions.mvp.QuestionListMVP
import com.code.knab.best_quiz.ui.questions.recycler.ItemClick
import com.code.knab.best_quiz.ui.questions.recycler.QuestionDiffResult
import com.code.knab.best_quiz.ui.questions.recycler.QuestionListAdapter
import com.code.knab.best_quiz.ui.single_question.SingleQuestionActivity
import kotlinx.android.synthetic.main.activity_question_list.*
import java.time.LocalDateTime
import javax.inject.Inject

class QuestionListActivity : AppCompatActivity(), QuestionListMVP.View, ItemClick<Question> {

    val CODE_FOR_CREATE = 123

    companion object {

        val PROJECT_KEY = "PROJECT_KEY"

        fun open(activity: Activity, lectureId: Int, code: Int){
            Intent(activity, QuestionListActivity::class.java).apply {
                this.putExtra(PROJECT_KEY, lectureId)
                activity.startActivityForResult(this, code)
            }
        }

    }

    @Inject
    lateinit var presenter: QuestionListMVP.Presenter

    private val adapter by lazy {
        QuestionListAdapter(this)
    }

    override fun open(t: Question) {
        SingleQuestionActivity.open(this, t.id, CODE_FOR_CREATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_list)
        QuestionListInjector().inject(this)

        questionsRecyclerView.layoutManager = LinearLayoutManager(this)
        questionsRecyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.load(intent.getIntExtra(PROJECT_KEY, 0))
    }

    override fun listLoaded(questionList: List<Question>) {
        adapter.replaceList(questionList, DiffUtil.calculateDiff(QuestionDiffResult(adapter.list, questionList)))
    }

    override fun handleErrorInView() {
        Toast.makeText(this, "We are very sory. There were some problems with http. Please try again later", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        presenter.compositeDisposal.clear()
    }
}
