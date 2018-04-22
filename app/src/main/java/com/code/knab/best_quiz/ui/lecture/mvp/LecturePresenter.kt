package com.code.knab.best_quiz.ui.lecture.mvp

import com.code.knab.best_quiz.network.json.Lecture
import com.code.knab.best_quiz.utils.rx.RxUtils
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

/**
 * Created by Michał on 21.04.2018.
 */
class LecturePresenter(private val view: LectureMVP.View,
                       private val model: LectureMVP.Model,
                       private val rxUtils: RxUtils): LectureMVP.Presenter {

    override val compositeDisposal: CompositeDisposable = CompositeDisposable()

    override fun loadLectures() {
        compositeDisposal.add(model.getLectures()
                .subscribeOn(rxUtils.subscribeScheduler)
                .observeOn(rxUtils.observScheduler)
                .subscribeWith(LoadLecturesObserver())
        )
    }

    inner class LoadLecturesObserver : DisposableSingleObserver<List<Lecture>>() {
        override fun onSuccess(lecture: List<Lecture>) {
            view.lecturesLoaded(lecture)
        }

        override fun onError(e: Throwable) {
            view.handleErrorInView()
        }
    }

}