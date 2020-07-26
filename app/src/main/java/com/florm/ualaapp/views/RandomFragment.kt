package com.florm.ualaapp.views

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.florm.ualaapp.R
import com.florm.ualaapp.models.Meal
import com.florm.ualaapp.viewmodels.ListViewModel

class RandomFragment : Fragment() {

    private var viewModel: ListViewModel? = null
    private var randomImage: ImageView? = null

    val timer = object: CountDownTimer(30000, 500) {
        override fun onTick(millisUntilFinished: Long) {}
        override fun onFinish() {
            viewModel?.updateRandomMeal()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_random, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewElements(view)
        observeViewModel()
    }

    private fun bindViewElements(view: View) {
        randomImage = view.findViewById(R.id.iv_random)
    }

    private fun observeViewModel() {
        viewModel?.randomMeal?.observe(this, Observer<Meal> {
            loadRandomImage(it)
            timer.start()
        })
    }

    private fun loadRandomImage(meal: Meal) {
        val urlString = meal.mealThumbURL

        randomImage?.let {
            Glide.with(this)
                .load(urlString)
                .into(it)
        }
    }

    companion object {
        fun newInstance(viewModel: ListViewModel): RandomFragment {
            val fragment = RandomFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }

}