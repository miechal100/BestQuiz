package com.code.knab.best_quiz.ui.lecture

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
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

        lectureAbbreviationEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                lectureLoginButton.isEnabled = true
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                lectureLoginButton.isEnabled = !s.isBlank()
            }
        })

        lectureLoginButton.setOnClickListener{
            presenter.loadLecture(lectureAbbreviationEditText.text.toString())
        }
    }


    override fun lectureLoaded(lecture: Lecture) {
        QuestionListActivity.open(this, lecture.id, CODE_FOR_CREATE)
    }

    override fun handleErrorInView() {
        Toast.makeText(this, "Wrong lecture abbreviation", Toast.LENGTH_SHORT).show()
    }
}
