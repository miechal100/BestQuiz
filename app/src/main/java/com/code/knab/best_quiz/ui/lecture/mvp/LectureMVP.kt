package com.code.knab.best_quiz.ui.lecture.mvp

import com.code.knab.best_quiz.network.json.Lecture
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Michał on 21.04.2018.
 */
interface LectureMVP {

    interface View {
        fun lectureLoaded()
    }

    interface Presenter {
        val compositeDisposal: CompositeDisposable
        fun loadLecture(abbreviation: String)
    }

    interface Model {
        fun getLecture(abbreviation: String): Single<Lecture>
    }

}