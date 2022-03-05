package com.example.mealtime

import android.os.Bundle
import android.view.Gravity.apply
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MealItemGroup : Fragment() {
    private var mealItems: Array<MealItem> = arrayOf(
        MealItem("Cheeseburger", 200, 6, 30)
    )
    private var time: String = "02:00 PM"
    private lateinit var mealItemGroup: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_meal_item_group, container, false)
        mealItemGroup = view.findViewById(R.id.mealItemGroup)
        mealItemGroup.setHasFixedSize(true)
        mealItemGroup.layoutManager = LinearLayoutManager(view.context)
        mealItemGroup.adapter = MealItemsAdapter(mealItems)
        return view
    }
}