package com.florm.ualaapp.viewmodels

import androidx.lifecycle.ViewModel
import com.florm.ualaapp.models.Meal

class MealDetailViewModel : ViewModel() {

    var mealDetails = Meal()
    var ingredientsList = listOf<String>()

    fun getIngredients(): String {
        ingredientsList = joinIngredients()
        return ingredientsList.joinToString(separator = "\n-", prefix = "-")
    }

    private fun joinIngredients(): List<String> {
        return listOfNotNull(
            checkIfIsNull(mealDetails.ingredient1),
            checkIfIsNull(mealDetails.ingredient2),
            checkIfIsNull(mealDetails.ingredient3),
            checkIfIsNull(mealDetails.ingredient4),
            checkIfIsNull(mealDetails.ingredient5),
            checkIfIsNull(mealDetails.ingredient6),
            checkIfIsNull(mealDetails.ingredient7),
            checkIfIsNull(mealDetails.ingredient8),
            checkIfIsNull(mealDetails.ingredient9),
            checkIfIsNull(mealDetails.ingredient10),
            checkIfIsNull(mealDetails.ingredient11),
            checkIfIsNull(mealDetails.ingredient12),
            checkIfIsNull(mealDetails.ingredient13),
            checkIfIsNull(mealDetails.ingredient14),
            checkIfIsNull(mealDetails.ingredient15),
            checkIfIsNull(mealDetails.ingredient16),
            checkIfIsNull(mealDetails.ingredient17),
            checkIfIsNull(mealDetails.ingredient18),
            checkIfIsNull(mealDetails.ingredient19),
            checkIfIsNull(mealDetails.ingredient20)
        )
    }

    private fun checkIfIsNull(ingredient: String?): String? {
        ingredient?.let {
            return if(ingredient.isNotEmpty()) {
                ingredient
            } else { null }
        }?: return null
    }

}