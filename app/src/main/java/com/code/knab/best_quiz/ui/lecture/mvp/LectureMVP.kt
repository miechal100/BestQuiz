package com.code.knab.best_quiz.ui.lecture.mvp

/**
 * Created by Michał on 21.04.2018.
 */
interface LectureMVP {

    interface View {
        fun lectureLoaded()
    }

    interface Presenter {
        fun loadLecture(abbreviation: String)
    }

    interface Model {
        fun getLecture(abbreviation: String)
    }

}