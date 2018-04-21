package com.code.knab.best_quiz.ui.questions.mvp

import com.code.knab.best_quiz.network.json.Question
import com.code.knab.best_quiz.utils.rx.RxUtils
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

/**
 * Created by Michał on 21.04.2018.
 */
class QuestionListPresenter(private val view: QuestionListMVP.View,
                            private val model: QuestionListMVP.Model,
                            private val rxUtils: RxUtils): QuestionListMVP.Presenter {

    override val compositeDisposal: CompositeDisposable = CompositeDisposable()

    override fun load(lectureId: Int) {
        compositeDisposal.add(model.getQuestionList(lectureId)
                .observeOn(rxUtils.observScheduler)
                .subscribeOn(rxUtils.subscribeScheduler)
                .subscribeWith(LoadQuestionObserver()))
    }

    inner class LoadQuestionObserver: DisposableSingleObserver<List<Question>>() {
        override fun onSuccess(questionList: List<Question>) {
            view.listLoaded(questionList)
        }

        override fun onError(e: Throwable) {
            view.handleErrorInView()
        }
    }

}