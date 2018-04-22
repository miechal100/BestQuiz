package com.code.knab.best_quiz.ui.single_question.dagger

import com.code.knab.best_quiz.network.api.SingleQuestionApi
import com.code.knab.best_quiz.ui.single_question.mvp.SingleQuestionMVP
import com.code.knab.best_quiz.ui.single_question.mvp.SingleQuestionModel
import com.code.knab.best_quiz.ui.single_question.mvp.SingleQuestionPresenter
import com.code.knab.best_quiz.utils.rx.RxUtils
import dagger.Module
import dagger.Provides

/**
 * Created by Michał on 22.04.2018.
 */
@Module
class SingleQuestionModule(private val view: SingleQuestionMVP.View) {

    @Provides
    @SingleQuestionScope
    fun providePresenter(model: SingleQuestionMVP.Model, rxUtils: RxUtils): SingleQuestionMVP.Presenter =
            SingleQuestionPresenter(view, model, rxUtils)

    @Provides
    @SingleQuestionScope
    fun provideModel(api: SingleQuestionApi): SingleQuestionMVP.Model =
            SingleQuestionModel(api)
}