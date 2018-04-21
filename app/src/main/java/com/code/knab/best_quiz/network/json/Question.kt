package com.code.knab.best_quiz.network.json

import java.time.LocalDateTime

/**
 * Created by Michał on 21.04.2018.
 */
data class Question(val id: String,
                    val content: String,
                    val lecturId: Int,
                    val createdAt: LocalDateTime)