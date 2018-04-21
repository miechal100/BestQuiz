package com.code.knab.best_quiz.ui.lecture

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.code.knab.best_quiz.R
import com.code.knab.best_quiz.ui.lecture.dagger.LectureInjector
import com.code.knab.best_quiz.ui.lecture.mvp.LectureMVP

class LectureActivity : AppCompatActivity(), LectureMVP.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecture)
        LectureInjector().inject(this)
    }

    override fun lectureLoaded() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
