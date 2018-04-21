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

    override fun loadLecture(abbreviation: String) {
        compositeDisposal.add(model.getLecture(abbreviation)
                .observeOn(rxUtils.observScheduler)
                .subscribeOn(rxUtils.subscribeScheduler)
                .subscribeWith(LoadLectureObserver())
        )
    }

    inner class LoadLectureObserver: DisposableSingleObserver<Lecture>() {
        override fun onSuccess(lecture: Lecture) {
            view.lectureLoaded(lecture)
        }

        override fun onError(e: Throwable) {
            view.handleErrorInView()
        }
    }

}