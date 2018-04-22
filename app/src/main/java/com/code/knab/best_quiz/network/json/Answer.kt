package com.code.knab.best_quiz.network.json

/**
 * Created by Michał on 22.04.2018.
 */
data class Answer(val id: Int,
                  val order: Int,
                  val content: String,
                  val questionId: Int)