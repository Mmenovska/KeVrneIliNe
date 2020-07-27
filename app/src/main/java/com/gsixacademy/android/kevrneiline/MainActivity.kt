package com.gsixacademy.android.kevrneiline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gsixacademy.android.kevrneiline.api.ServiceBuilder
import com.gsixacademy.android.kevrneiline.api.WeatherAPI
import com.gsixacademy.android.kevrneiline.models.MainList
import com.gsixacademy.android.kevrneiline.models.WeatherResponce
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ServiceBuilder.buildService(WeatherAPI::class.java)
        val call = request.getCurrentWeather("London")
        call.enqueue(object : Callback<WeatherResponce>{
            override fun onFailure(call: Call<WeatherResponce>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<WeatherResponce>,
                response: Response<WeatherResponce>
            ) {
                if (response.isSuccessful) {
                    var weatherResponce = response.body()
                    if (weatherResponce != null) {
                        text_view_city.text = weatherResponce.name
                        for (main in weatherResponce.main) {
                            text_view_temp.text = main.temp.toString()
                        }


                    }
                }
            }
        })
    }
}
