package com.code.knab.best_quiz.dagger

import android.content.Context
import com.code.knab.best_quiz.utils.rx.RxUtils
import com.code.knab.best_quiz.utils.rx.RxUtilsImpl
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors
import javax.inject.Singleton

/**
 * Created by Michał on 21.04.2018.
 */
@Module
class AppModule(context: Context) {

    @Provides
    @Singleton
    fun provideRxUtils(): RxUtils = RxUtilsImpl(AndroidSchedulers.mainThread(),
            Schedulers.from(Executors.newFixedThreadPool(4)))


}