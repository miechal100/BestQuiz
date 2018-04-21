package com.code.knab.best_quiz.ui.questions.dagger

import com.code.knab.best_quiz.ui.questions.QuestionListActivity
import dagger.Component
import dagger.Subcomponent

/**
 * Created by Michał on 21.04.2018.
 */
@QuestionsListScope
@Subcomponent(modules = arrayOf(QuestionListModule::class))
interface QuestionListComponent {

    fun inject(activity: QuestionListActivity)

}