package com.code.knab.best_quiz.ui.questions

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.code.knab.best_quiz.R
import com.code.knab.best_quiz.network.json.Question
import com.code.knab.best_quiz.ui.questions.mvp.QuestionListMVP

class QuestionListActivity : AppCompatActivity(), QuestionListMVP.View {
    companion object {

        val PROJECT_KEY = "PROJECT_KEY"
        fun open(activity: Activity, lectureId: Int, code: Int){
            Intent(activity, QuestionListActivity::class.java).apply {
                this.putExtra(PROJECT_KEY, lectureId)
                activity.startActivityForResult(this, code)
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_list)
    }

    override fun setLoading(loading: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listLoaded(questionList: List<Question>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
