package com.florm.ualaapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.florm.ualaapp.models.Meal
import com.florm.ualaapp.repositories.MealsRepository

class ListViewModel : ViewModel() {
    private var repository: MealsRepository = MealsRepository().getInstance()

    var mealsList: LiveData<List<Meal>> = repository.getMeals()
    var randomMeal: MutableLiveData<Meal> = repository.getRandomMeal()

    fun updateRandomMeal() {
        repository.updateRandomMeal {
            randomMeal.postValue(it)
        }
    }

}