package com.code.knab.best_quiz.ui.questions.recycler

import com.code.knab.best_quiz.network.json.Question
import com.code.knab.best_quiz.utils.recycler.BasicViewUtils

/**
 * Created by Michał on 21.04.2018.
 */
class QuestionDiffResult(oldList: List<Question>, newList: List<Question>)
    : BasicViewUtils<Question>(oldList, newList) {

    override fun areItemsTeSame(t1: Question, t2: Question): Boolean = t1.id == t2.id

}