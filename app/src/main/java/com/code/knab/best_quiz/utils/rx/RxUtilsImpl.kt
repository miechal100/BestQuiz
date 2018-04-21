package com.code.knab.best_quiz.utils.rx

import io.reactivex.Scheduler

/**
 * Created by Michał on 21.04.2018.
 */
class RxUtilsImpl(override val observScheduler: Scheduler,
                  override val subscribeScheduler: Scheduler): RxUtils {
}