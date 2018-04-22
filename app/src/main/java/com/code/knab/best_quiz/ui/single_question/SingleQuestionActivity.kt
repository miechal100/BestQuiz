package com.code.knab.best_quiz.ui.single_question

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.code.knab.best_quiz.R

class SingleQuestionActivity : AppCompatActivity() {

    companion object {

        val PROJECT_KEY = "PROJECT_KEY"

        fun open(activity: Activity, questionId: Int, code: Int){
            Intent(activity, SingleQuestionActivity::class.java).apply {
                this.putExtra(PROJECT_KEY, questionId)
                activity.startActivityForResult(this, code)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_question)


    }
}
