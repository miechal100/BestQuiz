package com.code.knab.best_quiz.network.api

import com.code.knab.best_quiz.network.json.Lecture
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Michał on 21.04.2018.
 */
interface LectureApi {

    @GET("lectures")
    fun getLectures(): Single<List<Lecture>>

    @GET("lectures/{lectureId}")
    fun getLectureByAbbreaviation(@Path("lectureId") id: String): Single<Lecture>

}