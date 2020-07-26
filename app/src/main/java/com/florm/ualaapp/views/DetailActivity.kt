package com.florm.ualaapp.views

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.florm.ualaapp.R
import com.florm.ualaapp.models.Meal
import com.florm.ualaapp.viewmodels.MealDetailViewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel : MealDetailViewModel

    private var mealTextView: TextView? = null
    private var ingredientsTextView: TextView? = null
    private var instructionsTextView: TextView? = null
    private var backArrowImageButton: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        bindViewElements()
        createViewModel()
        getIntentData()
        addListeners()
    }

    private fun bindViewElements() {
        mealTextView = findViewById(R.id.tv_meal)
        ingredientsTextView = findViewById(R.id.tv_ingredients_list)
        instructionsTextView = findViewById(R.id.tv_instructions)
        backArrowImageButton = findViewById(R.id.btn_back_arrow)
    }

    private fun createViewModel() {
        viewModel = ViewModelProvider(this).get(MealDetailViewModel::class.java)
    }

    private fun getIntentData() {
        viewModel.mealDetails  = intent.getSerializableExtra("EXTRA_MEAL") as Meal
        loadMealDetails()
    }

    private fun addListeners() {
        backArrowImageButton?.setOnClickListener { finish() }
    }

    private fun loadMealDetails() {
        viewModel.mealDetails.let {
            mealTextView?.text =  getString(R.string.meal_name, it.meal)
            instructionsTextView?.text = it.instructions
            ingredientsTextView?.text = viewModel.getIngredients()
        }
    }

}