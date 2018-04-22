package com.code.knab.best_quiz.ui.questions.mvp

import com.code.knab.best_quiz.network.api.QuestionListApi
import com.code.knab.best_quiz.network.json.Question
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit

/**
 * Created by Michał on 21.04.2018.
 */
class QuestionListModel(private val api: QuestionListApi): QuestionListMVP.Model {
    override fun getQuestionList(lectureId: Int): Observable<List<Question>> =
            Observable.interval(0,30, TimeUnit.SECONDS)
                    .flatMap { api.getQuestions(lectureId)}
}