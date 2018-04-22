package com.code.knab.best_quiz.ui.questions.mvp

import com.code.knab.best_quiz.network.json.Question
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Michał on 21.04.2018.
 */
interface QuestionListMVP {

    interface View {
        fun setLoading(loading: Boolean)
        fun listLoaded(questionList: List<Question>)
        fun handleErrorInView()
    }

    interface Presenter {
        val compositeDisposal: CompositeDisposable
        fun load(lectureId: Int)
    }

    interface Model {
        fun getQuestionList(lectureId: Int): Observable<List<Question>>
    }
}