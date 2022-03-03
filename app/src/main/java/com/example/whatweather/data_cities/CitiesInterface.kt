package com.example.whatweather.data_cities

import retrofit2.Call
import retrofit2.http.GET

interface CitiesInterface {

    @GET("geo/1.0/direct?q=London&limit=5&appid=013d4758fab60b271e804fb1aa53f2e6")
    fun getData(): Call<List<CityItem>>
}