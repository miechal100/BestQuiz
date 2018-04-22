package com.code.knab.best_quiz.ui.lecture

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.code.knab.best_quiz.R
import com.code.knab.best_quiz.network.json.Lecture
import com.code.knab.best_quiz.ui.lecture.dagger.LectureInjector
import com.code.knab.best_quiz.ui.lecture.mvp.LectureMVP
import com.code.knab.best_quiz.ui.lecture.recycler.LecturesDiffResult
import com.code.knab.best_quiz.ui.lecture.recycler.LecturesListAdapter
import com.code.knab.best_quiz.ui.questions.QuestionListActivity
import com.code.knab.best_quiz.ui.questions.recycler.ItemClick
import kotlinx.android.synthetic.main.activity_lecture.*
import javax.inject.Inject

class LectureActivity : AppCompatActivity(), LectureMVP.View, ItemClick<Lecture> {
    val CODE_FOR_CREATE = 123

    @Inject
    lateinit var presenter: LectureMVP.Presenter

    val adapter by lazy {
        LecturesListAdapter(this)
    }

    override fun open(t: Lecture) {
        QuestionListActivity.open(this, t.id, CODE_FOR_CREATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecture)
        LectureInjector().inject(this)

        setTitle("Lectures")

        lectureRecyclerView.layoutManager = LinearLayoutManager(this)
        lectureRecyclerView.adapter = adapter

        presenter.loadLectures()

    }


    override fun lecturesLoaded(lecturesList: List<Lecture>) {
        adapter.replaceList(lecturesList, DiffUtil.calculateDiff(LecturesDiffResult(adapter.list, lecturesList)))
    }

    override fun handleErrorInView() {
        Toast.makeText(this, "Wrong lecture abbreviation", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        presenter.compositeDisposal.clear()
    }
}
