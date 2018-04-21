package com.code.knab.best_quiz.utils.rx

import io.reactivex.Scheduler

/**
 * Created by Michał on 21.04.2018.
 */
interface RxUtils {
    val observScheduler: Scheduler
    val subscribeScheduler: Scheduler
}