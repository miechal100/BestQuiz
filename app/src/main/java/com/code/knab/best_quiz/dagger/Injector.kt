package com.code.knab.best_quiz.dagger

/**
 * Created by Michał on 21.04.2018.
 */
interface Injector<in T> {
    fun inject(target:T)
}