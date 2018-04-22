package com.code.knab.best_quiz.ui.questions.recycler

import com.code.knab.best_quiz.network.json.Question

/**
 * Created by Michał on 21.04.2018.
 */
interface ItemClick {
    fun open(question: Question)
}