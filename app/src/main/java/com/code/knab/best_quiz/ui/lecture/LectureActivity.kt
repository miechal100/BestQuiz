package com.code.knab.best_quiz.ui.lecture

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.code.knab.best_quiz.R
import com.code.knab.best_quiz.ui.lecture.dagger.LectureInjector
import com.code.knab.best_quiz.ui.lecture.mvp.LectureMVP
import javax.inject.Inject

class LectureActivity : AppCompatActivity(), LectureMVP.View {

    @Inject
    lateinit var presenter: LectureMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecture)
        LectureInjector().inject(this)
        presenter.loadLecture("")
    }

    override fun lectureLoaded() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
