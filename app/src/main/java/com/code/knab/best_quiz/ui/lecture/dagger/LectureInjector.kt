package com.code.knab.best_quiz.ui.lecture.dagger

import com.code.knab.best_quiz.BestQuizApp
import com.code.knab.best_quiz.dagger.Injector
import com.code.knab.best_quiz.ui.lecture.LectureActivity

/**
 * Created by Michał on 21.04.2018.
 */
class LectureInjector: Injector<LectureActivity> {
    override fun inject(target: LectureActivity) {
        (target.applicationContext as BestQuizApp).component.plus(LectureModule(target)).inject(target)
    }
}