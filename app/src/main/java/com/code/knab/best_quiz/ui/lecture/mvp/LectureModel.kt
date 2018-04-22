package com.code.knab.best_quiz.ui.lecture.mvp

import com.code.knab.best_quiz.network.api.LectureApi
import com.code.knab.best_quiz.network.json.Lecture
import io.reactivex.Single

/**
 * Created by Michał on 21.04.2018.
 */
class LectureModel(private val api: LectureApi): LectureMVP.Model {
    override fun getLectures(): Single<List<Lecture>> {
        return api.getLectures()
    }
}