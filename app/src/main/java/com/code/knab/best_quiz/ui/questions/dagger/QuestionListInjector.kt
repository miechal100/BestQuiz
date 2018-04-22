package com.code.knab.best_quiz.ui.questions.dagger

import com.code.knab.best_quiz.BestQuizApp
import com.code.knab.best_quiz.dagger.Injector
import com.code.knab.best_quiz.ui.questions.QuestionListActivity

/**
 * Created by Michał on 21.04.2018.
 */
class QuestionListInjector: Injector<QuestionListActivity> {
    override fun inject(target: QuestionListActivity) {
        (target.applicationContext as BestQuizApp).component.plus(QuestionListModule(target)).inject(target)
    }

}