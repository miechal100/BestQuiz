package com.code.knab.best_quiz.network

import android.util.Log
import com.code.knab.best_quiz.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Michał on 21.04.2018.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson) =
            Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl("https://best-quiz.herokuapp.com")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(prepareOkHttpClient())
                    .build()

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create()
    }

    private fun prepareOkHttpClient(): OkHttpClient {
        val http = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)

        val myLogger = HttpLoggingInterceptor.Logger { message -> Log.d("CAR_APP", message) }
        val loggingInterceptor = HttpLoggingInterceptor(myLogger)
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        http.addInterceptor(loggingInterceptor)

        return http.build()
    }

}