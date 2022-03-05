package com.example.mealtime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MealItemsAdapter(private val mealItems: Array<MealItem>) : RecyclerView.Adapter<MealItemsAdapter.MealItemViewHolder>() {
    class MealItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mealItemName: TextView = view.findViewById(R.id.mealItemName)
        val mealItemDescription: TextView = view.findViewById(R.id.mealItemDescription)
        val mealItemImage: ImageView = view.findViewById(R.id.mealItemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_meal_item, parent, false)
        return MealItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealItemViewHolder, position: Int) {
        holder.mealItemName.text = mealItems[position].name
        holder.mealItemDescription.text = mealItems[position].calories.toString()
        holder.mealItemImage.setImageResource(R.drawable.ic_launcher_background)
    }

    override fun getItemCount(): Int {
        return mealItems.size
    }
}