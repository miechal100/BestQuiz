package com.code.knab.best_quiz.ui.questions.dagger

import com.code.knab.best_quiz.network.api.QuestionListApi
import com.code.knab.best_quiz.ui.questions.mvp.QuestionListMVP
import com.code.knab.best_quiz.ui.questions.mvp.QuestionListModel
import com.code.knab.best_quiz.ui.questions.mvp.QuestionListPresenter
import com.code.knab.best_quiz.utils.rx.RxUtils
import dagger.Module
import dagger.Provides

/**
 * Created by Michał on 21.04.2018.
 */
@Module
class QuestionListModule(private val view: QuestionListMVP.View) {

    @Provides
    @QuestionsListScope
    fun providePresenter(model: QuestionListMVP.Model, rxUtils: RxUtils): QuestionListMVP.Presenter = QuestionListPresenter(view, model, rxUtils)

    @Provides
    @QuestionsListScope
    fun provideModel(api: QuestionListApi): QuestionListMVP.Model = QuestionListModel(api)
}