package com.code.knab.best_quiz.ui.lecture.recycler

import com.code.knab.best_quiz.network.json.Lecture
import com.code.knab.best_quiz.network.json.Question
import com.code.knab.best_quiz.utils.recycler.BasicViewUtils

/**
 * Created by Michał on 21.04.2018.
 */
class LecturesDiffResult(oldList: List<Lecture>, newList: List<Lecture>)
    : BasicViewUtils<Lecture>(oldList, newList) {

    override fun areItemsTeSame(t1: Lecture, t2: Lecture): Boolean = t1.id == t2.id

}