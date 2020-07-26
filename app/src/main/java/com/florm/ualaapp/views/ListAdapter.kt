package com.florm.ualaapp.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.florm.ualaapp.R
import com.florm.ualaapp.models.Meal
import java.util.*

class ListAdapter(private var list: MutableList<Meal>, private var listener: ListActivityBridge): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var mealsList = list
    var originalMealList = ArrayList(mealsList)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return mealsList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mealsList[position]

        holder.titleTextView?.text = item.meal
        holder.categoryTextView?.text = item.category

        holder.image?.let {
            if(item.mealThumbURL != null) {

                val urlString = item.mealThumbURL

                Glide.with(holder.itemView.context)
                    .load(urlString)
                    .into(it)
            }
        }

        holder.container?.setOnClickListener {
            listener.onItemClicked(item)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var container: LinearLayout? = itemView.findViewById(R.id.container)
        var titleTextView: TextView? = itemView.findViewById(R.id.tv_title)
        var categoryTextView: TextView? = itemView.findViewById(R.id.tv_category)
        var image: ImageView? = itemView.findViewById(R.id.image_view)
    }

    fun searchMeal(text: String?) {
        val inputText = text!!.toLowerCase(Locale.getDefault())

        mealsList.clear()

        if (inputText.isEmpty()) {
            mealsList.addAll(originalMealList)
        } else {
            for (i in 0 until originalMealList.size) {
                originalMealList[i].meal?.let { meal ->
                    if (meal.toLowerCase(Locale.getDefault()).contains(inputText)) {
                        mealsList.add(originalMealList[i])
                    }
                }
            }
        }
        notifyDataSetChanged()
    }

    interface ListActivityBridge {
        fun onItemClicked(item: Meal)
    }

}
