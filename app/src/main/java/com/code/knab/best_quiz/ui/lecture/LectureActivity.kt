package com.code.knab.best_quiz.ui.lecture

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.code.knab.best_quiz.R
import com.code.knab.best_quiz.network.json.Lecture
import com.code.knab.best_quiz.ui.lecture.dagger.LectureInjector
import com.code.knab.best_quiz.ui.lecture.mvp.LectureMVP
import com.code.knab.best_quiz.ui.questions.QuestionListActivity
import kotlinx.android.synthetic.main.activity_lecture.*
import javax.inject.Inject

class LectureActivity : AppCompatActivity(), LectureMVP.View {

    val CODE_FOR_CREATE = 123

    @Inject
    lateinit var presenter: LectureMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecture)
        LectureInjector().inject(this)
        presenter.loadLecture(lectureAbbreviationEditText.text.toString())
    }

    override fun lectureLoaded(lecture: Lecture) {
        QuestionListActivity.open(this, lecture.id, CODE_FOR_CREATE)
    }
}
