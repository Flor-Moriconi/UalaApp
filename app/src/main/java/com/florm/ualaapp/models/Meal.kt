package com.florm.ualaapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Meal(
    @SerializedName("idMeal")
    var idMeal: String? = null,
    @SerializedName("strMeal")
    var meal: String? = null,
    @SerializedName("strCategory")
    var category: String? = null,
    @SerializedName("strInstructions")
    var instructions: String? = null,
    @SerializedName("strMealThumb")
    var mealThumbURL: String? = null,
    @SerializedName("strYoutube")
    var youtubeURL: String? = null,
    @SerializedName("strIngredient1")
    var ingredient1: String? = null,
    @SerializedName("strIngredient2")
    var ingredient2: String? = null,
    @SerializedName("strIngredient3")
    var ingredient3: String? = null,
    @SerializedName("strIngredient4")
    var ingredient4: String? = null,
    @SerializedName("strIngredient5")
    var ingredient5: String? = null,
    @SerializedName("strIngredient6")
    var ingredient6: String? = null,
    @SerializedName("strIngredient7")
    var ingredient7: String? = null,
    @SerializedName("strIngredient8")
    var ingredient8: String? = null,
    @SerializedName("strIngredient9")
    var ingredient9: String? = null,
    @SerializedName("strIngredient10")
    var ingredient10: String? = null,
    @SerializedName("strIngredient11")
    var ingredient11: String? = null,
    @SerializedName("strIngredient12")
    var ingredient12: String? = null,
    @SerializedName("strIngredient13")
    var ingredient13: String? = null,
    @SerializedName("strIngredient14")
    var ingredient14: String? = null,
    @SerializedName("strIngredient15")
    var ingredient15: String? = null,
    @SerializedName("strIngredient16")
    var ingredient16: String? = null,
    @SerializedName("strIngredient17")
    var ingredient17: String? = null,
    @SerializedName("strIngredient18")
    var ingredient18: String? = null,
    @SerializedName("strIngredient19")
    var ingredient19: String? = null,
    @SerializedName("strIngredient20")
    var ingredient20: String? = null) : Serializable
