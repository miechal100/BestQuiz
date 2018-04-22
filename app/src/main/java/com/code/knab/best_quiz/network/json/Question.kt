package com.code.knab.best_quiz.network.json

import java.util.*

/**
 * Created by Michał on 21.04.2018.
 */
data class Question(val id: Int,
                    val content: String,
                    val lectureId: Int,
                    val createdAt: Date,
                    val answers: List<Answer>)