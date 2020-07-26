package com.florm.ualaapp.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.florm.ualaapp.RetrofitService
import com.florm.ualaapp.models.Meal
import com.florm.ualaapp.models.MealsResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository {
    private val service = RetrofitService().service

    fun getInstance(): MealsRepository {
        return MealsRepository()
    }

    fun getMeals(): LiveData<List<Meal>> {
        val meals = MutableLiveData<List<Meal>>()

        service.getAllMeals().enqueue(object : Callback<MealsResponse> {

            override fun onResponse(call: Call<MealsResponse>, response: Response<MealsResponse>) {
                val mealsResponse = response.body()
                meals.value = mealsResponse?.meals
            }

            override fun onFailure(call: Call<MealsResponse>, t: Throwable) {
                t.printStackTrace()
            }

        })

        return meals
    }


     fun getRandomMeal(): MutableLiveData<Meal> {
        val randomMeal = MutableLiveData<Meal>()
        service.getRandomMeal().enqueue(object : Callback<MealsResponse> {

            override fun onResponse(call: Call<MealsResponse>, response: Response<MealsResponse>) {
                val mealsResponse = response.body()
                randomMeal.value = mealsResponse?.meals?.first()
            }

            override fun onFailure(call: Call<MealsResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return randomMeal
    }

    fun updateRandomMeal(callback: (Meal?) -> Unit) {
        val randomMeal = MutableLiveData<Meal>()
        service.getRandomMeal().enqueue(object : Callback<MealsResponse> {

            override fun onResponse(call: Call<MealsResponse>, response: Response<MealsResponse>) {
                if(response.isSuccessful){
                    val mealsResponse = response.body()
                    randomMeal.value = mealsResponse?.meals?.first()
                    callback(randomMeal.value)
                } else {
                    response.errorBody()?.let {
                        val errorBody: ResponseBody = it
                        Log.e("", errorBody.toString())
                    }
                    callback(null)
                }
            }

            override fun onFailure(call: Call<MealsResponse>, t: Throwable) {
                t.printStackTrace()
                callback(null)
            }
        })
    }

}