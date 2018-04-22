package com.code.knab.best_quiz.network.api

import com.code.knab.best_quiz.network.json.Question
import com.code.knab.best_quiz.network.model.QuestionAnsweredResponse
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by Michał on 22.04.2018.
 */
interface SingleQuestionApi {

    @POST("answer_event")
    fun postAnswer(@Body answerId: Int): Single<QuestionAnsweredResponse>

    @GET("questions/{id}")
    fun getSingleQuestion(@Path("id") id: Int): Single<Question>
}