package com.gsixacademy.android.kevrneiline.api

import com.gsixacademy.android.kevrneiline.models.WeatherResponce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val apiKey = "appid=93b0e12d1afc9485dfd7f2441a9d6b73"

interface WeatherAPI {

    @GET ("/data/2.5/weather?q={city name}" + apiKey)
    fun getCurrentWeather ( @Path ("city name") city_name : String?) : Call<WeatherResponce>
}