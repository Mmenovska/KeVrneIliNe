package com.gsixacademy.android.kevrneiline.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceBuilder {

    val client = OkHttpClient.Builder().build()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildService ( service : Class <T>) : T {
        return retrofit.create(service)
    }
}