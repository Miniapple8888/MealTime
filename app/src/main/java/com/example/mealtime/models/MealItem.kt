package com.example.mealtime

import androidx.annotation.DrawableRes

data class MealItem (
    val name: String,
    val calories: Int,
    val servings: Int,
    val prepTime: Int,
)