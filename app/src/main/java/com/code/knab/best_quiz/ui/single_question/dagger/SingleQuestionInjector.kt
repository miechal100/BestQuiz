package com.code.knab.best_quiz.ui.single_question.dagger

import com.code.knab.best_quiz.BestQuizApp
import com.code.knab.best_quiz.dagger.Injector
import com.code.knab.best_quiz.ui.single_question.SingleQuestionActivity

/**
 * Created by Michał on 22.04.2018.
 */
class SingleQuestionInjector: Injector<SingleQuestionActivity> {

    override fun inject(target: SingleQuestionActivity) {
        (target.applicationContext as BestQuizApp).component.plus(SingleQuestionModule(target))
                .inject(target)
    }
}