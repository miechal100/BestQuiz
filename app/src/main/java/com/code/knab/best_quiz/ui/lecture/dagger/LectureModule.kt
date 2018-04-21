package com.code.knab.best_quiz.ui.lecture.dagger

import com.code.knab.best_quiz.network.api.LectureApi
import com.code.knab.best_quiz.ui.lecture.mvp.LectureMVP
import com.code.knab.best_quiz.ui.lecture.mvp.LectureModel
import com.code.knab.best_quiz.ui.lecture.mvp.LecturePresenter
import com.code.knab.best_quiz.utils.rx.RxUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Michał on 21.04.2018.
 */
@Module
class LectureModule(private val view: LectureMVP.View) {

    @Provides
    @LectureScope
    fun providePresenter(model: LectureMVP.Model, rxUtils: RxUtils): LectureMVP.Presenter = LecturePresenter(view, model, rxUtils)

    @Provides
    @LectureScope
    fun provideModel(api: LectureApi): LectureMVP.Model = LectureModel(api)

}