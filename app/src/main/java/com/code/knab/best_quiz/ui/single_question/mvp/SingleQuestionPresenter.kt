package com.code.knab.best_quiz.ui.single_question.mvp

import com.code.knab.best_quiz.network.json.Question
import com.code.knab.best_quiz.network.model.QuestionAnsweredResponse
import com.code.knab.best_quiz.utils.rx.RxUtils
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

/**
 * Created by Michał on 22.04.2018.
 */
class SingleQuestionPresenter(private val view: SingleQuestionMVP.View,
                              private val model: SingleQuestionMVP.Model,
                              private val rxUtils: RxUtils): SingleQuestionMVP.Presenter {

    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun loadQuestion(questionId: Int) {
        compositeDisposable.add(model.getQuestion(questionId)
                .subscribeOn(rxUtils.subscribeScheduler)
                .observeOn(rxUtils.observScheduler)
                .subscribeWith(LoadQuestionObserver()))
    }

    override fun answer(answerId: Int) {
        compositeDisposable.add(model.postAnswer(answerId)
                .subscribeOn(rxUtils.subscribeScheduler)
                .observeOn(rxUtils.observScheduler)
                .subscribeWith(PostAnswerObserver())
        )
    }

    inner class LoadQuestionObserver: DisposableSingleObserver<Question>(){
        override fun onSuccess(question: Question) {
            view.displayQuestion(question)
        }

        override fun onError(e: Throwable) {
            view.handleErrorInView()
        }

    }

    inner class PostAnswerObserver: DisposableSingleObserver<QuestionAnsweredResponse>() {
        override fun onSuccess(t: QuestionAnsweredResponse) {
            view.submitCompleted(t.isCorrect==1)
        }

        override fun onError(e: Throwable) {
            view.handleErrorInView()
        }
    }


}