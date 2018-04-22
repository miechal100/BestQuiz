package com.code.knab.best_quiz.network.api

import com.code.knab.best_quiz.network.json.Question
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Michał on 21.04.2018.
 */
interface QuestionListApi {

    @GET("questions")
    fun getQuestions(@Query("lectureId") lectureId: Int, @Query("published") published: Int = 1): Observable<List<Question>>

}