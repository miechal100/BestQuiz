package com.code.knab.best_quiz.ui.single_question.mvp

import com.code.knab.best_quiz.network.json.Question
import com.code.knab.best_quiz.network.model.QuestionAnsweredResponse
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Michał on 22.04.2018.
 */
interface SingleQuestionMVP {

    interface View {
        fun displayQuestion(question: Question)
        fun handleErrorInView()
        fun submitCompleted(answeredCorrectly: Boolean)
    }

    interface Presenter {
        val compositeDisposable: CompositeDisposable
        fun answer(answerId: Int)
        fun loadQuestion(questionId: Int)
    }

    interface Model {
        fun postAnswer(answerId: Int): Single<QuestionAnsweredResponse>
        fun getQuestion(questionId: Int): Single<Question>
    }

}