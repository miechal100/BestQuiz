package com.code.knab.best_quiz.ui.single_question.dagger

import com.code.knab.best_quiz.ui.single_question.SingleQuestionActivity
import dagger.Subcomponent

/**
 * Created by Michał on 22.04.2018.
 */
@SingleQuestionScope
@Subcomponent(modules = arrayOf(SingleQuestionModule::class))
interface SingleQuestionComponent {

    fun inject(activity: SingleQuestionActivity)
}