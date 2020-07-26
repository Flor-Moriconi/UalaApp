package com.florm.ualaapp

import com.florm.ualaapp.models.MealsResponse
import retrofit2.Call
import retrofit2.http.GET

interface MealsApi {

    @GET("search.php?s=")
    fun getAllMeals(): Call<MealsResponse>

    @GET("random.php")
    fun getRandomMeal(): Call<MealsResponse>

}