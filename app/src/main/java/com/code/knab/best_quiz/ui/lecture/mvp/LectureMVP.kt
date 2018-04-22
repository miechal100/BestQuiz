package com.code.knab.best_quiz.ui.lecture.mvp

import com.code.knab.best_quiz.network.json.Lecture
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Michał on 21.04.2018.
 */
interface LectureMVP {

    interface View {
        fun lecturesLoaded(lecturesList: List<Lecture>)
        fun handleErrorInView()
    }

    interface Presenter {
        val compositeDisposal: CompositeDisposable
        fun loadLectures()
    }

    interface Model {
        fun getLectures(): Single<List<Lecture>>
    }

}