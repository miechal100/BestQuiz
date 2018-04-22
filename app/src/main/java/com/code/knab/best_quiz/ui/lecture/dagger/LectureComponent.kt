package com.code.knab.best_quiz.ui.lecture.dagger

import com.code.knab.best_quiz.ui.lecture.LectureActivity
import dagger.Subcomponent

/**
 * Created by Michał on 21.04.2018.
 */
@LectureScope
@Subcomponent(modules = arrayOf(LectureModule::class))
interface LectureComponent {
    fun inject(activity: LectureActivity)
}