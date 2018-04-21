package com.code.knab.best_quiz.ui.questions

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.util.DiffUtil
import com.code.knab.best_quiz.R
import com.code.knab.best_quiz.network.json.Question
import com.code.knab.best_quiz.ui.questions.dagger.QuestionListInjector
import com.code.knab.best_quiz.ui.questions.mvp.QuestionListMVP
import com.code.knab.best_quiz.ui.questions.recycler.ItemClick
import com.code.knab.best_quiz.ui.questions.recycler.QuestionDiffResult
import com.code.knab.best_quiz.ui.questions.recycler.QuestionListAdapter
import javax.inject.Inject

class QuestionListActivity : AppCompatActivity(), QuestionListMVP.View, ItemClick<Question> {
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

    override fun open(question: Question) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_list)
        QuestionListInjector().inject(this)


    }

    override fun setLoading(loading: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listLoaded(questionList: List<Question>) {
        adapter.replaceList(questionList, DiffUtil.calculateDiff(QuestionDiffResult(adapter.list, questionList)))
    }
}
