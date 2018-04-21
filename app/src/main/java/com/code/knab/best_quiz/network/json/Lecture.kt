package com.code.knab.best_quiz.network.json

import java.time.DayOfWeek
import java.time.LocalTime

/**
 * Created by Michał on 21.04.2018.
 */
data class Lecture (val id: Int,
                    val abbreviation: String,
                    val name: String,
                    val day: DayOfWeek,
                    val startDate: LocalTime,
                    val finishDate: LocalTime)
