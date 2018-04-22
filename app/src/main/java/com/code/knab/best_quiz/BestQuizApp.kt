package com.code.knab.best_quiz

import android.app.Application
import com.code.knab.best_quiz.dagger.AppModule
import com.code.knab.best_quiz.dagger.DaggerAppComponent
import com.code.knab.best_quiz.network.NetworkModule
import com.code.knab.best_quiz.network.api.NetworkApiModule

/**
 * Created by Michał on 21.04.2018.
 */

class BestQuizApp: Application(){

    val component by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkApiModule(NetworkApiModule())
                .networkModule(NetworkModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}