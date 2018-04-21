package com.code.knab.best_quiz.ui.lecture.mvp

import com.code.knab.best_quiz.utils.rx.RxUtils
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Michał on 21.04.2018.
 */
class LecturePresenter(private val view: LectureMVP.View,
                       private val model: LectureMVP.Model,
                       private val rxUtils: RxUtils): LectureMVP.Presenter {

    override val compositeDisposal: CompositeDisposable = CompositeDisposable()

    override fun loadLecture(abbreviation: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}