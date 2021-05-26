package ru.geekbrains.androidonkotlin.hw.mymovie.domain.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientTmdb {
    var retrofit: Retrofit? = null
    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit!!
    }
}