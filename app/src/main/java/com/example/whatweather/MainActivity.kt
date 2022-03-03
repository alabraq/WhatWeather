package com.example.whatweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.whatweather.data_cities.CitiesInterface
import com.example.whatweather.data_cities.CityItem
import com.example.whatweather.ui.main.MainFragment
import com.example.whatweather.ui.main.SecondFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL_OPEN_WEATHER_MAP = "https://api.openweathermap.org/"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        supportFragmentManager.beginTransaction().apply {
            add(R.id.containerMainFragment, MainFragment.newInstance())
            add(R.id.containerSecondFragment, SecondFragment.newInstance())
            commit()
        }

        getCitiesFromOpenWeatherMap("")

    }

    private fun getCitiesFromOpenWeatherMap(cityName: String) {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_OPEN_WEATHER_MAP)
            .build()
            .create(CitiesInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<CityItem>?> {
            override fun onResponse(call: Call<List<CityItem>?>, response: Response<List<CityItem>?>) {
                val responseBody = response.body()
                for (cityItem in responseBody!!) {
                    Log.e("resultCity", "${cityItem.name} / ${cityItem.country}")
                }
            }
            override fun onFailure(call: Call<List<CityItem>?>, t: Throwable) {
                Log.e("onFailure_getCitiesFromOpenWeatherMap", t.message.toString())
            }
        })

    }
}