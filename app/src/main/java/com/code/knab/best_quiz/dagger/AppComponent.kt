package com.code.knab.best_quiz.dagger

import com.code.knab.best_quiz.network.NetworkModule
import com.code.knab.best_quiz.network.api.NetworkApiModule
import com.code.knab.best_quiz.ui.lecture.dagger.LectureComponent
import com.code.knab.best_quiz.ui.lecture.dagger.LectureModule
import com.code.knab.best_quiz.ui.questions.dagger.QuestionListComponent
import com.code.knab.best_quiz.ui.questions.dagger.QuestionListModule
import com.code.knab.best_quiz.ui.single_question.dagger.SingleQuestionComponent
import com.code.knab.best_quiz.ui.single_question.dagger.SingleQuestionModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Michał on 21.04.2018.
 */
@Component(modules = arrayOf(AppModule::class, NetworkApiModule::class, NetworkModule::class))
@Singleton
interface AppComponent {

    fun plus(lectureModule: LectureModule): LectureComponent
    fun plus(questionListModule: QuestionListModule): QuestionListComponent
    fun plus(singleQuestionModule: SingleQuestionModule): SingleQuestionComponent
}