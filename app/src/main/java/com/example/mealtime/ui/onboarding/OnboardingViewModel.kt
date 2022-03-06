package com.example.mealtime.ui.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnboardingViewModel : ViewModel() {
    private val _dietary = MutableLiveData<ArrayList<String>>()
    val dietary: LiveData<ArrayList<String>> = _dietary

    private val _calorie = MutableLiveData<String>("1000-1500")
    val calorie: LiveData<String> = _calorie

    private val _macro = MutableLiveData<String>("40/30/30")
    val macro: LiveData<String> = _macro

    private val _budget = MutableLiveData<String>("low")
    val budget: LiveData<String> = _budget

    private val _time = MutableLiveData<String>("Less than 15min")
    val prepTime: LiveData<String> = _time

    init {
        // Set initial values for the preference
        resetPref()
    }


    fun setDietary(desiredDietaries: ArrayList<String>) {
        _dietary.value = desiredDietaries
    }

    fun setCalorie(desiredCalorie: String) {
        _calorie.value = desiredCalorie
    }

    fun setMacro(desiredMacro: String) {
        _macro.value = desiredMacro
    }

    fun setBudget(desiredBudget: String) {
        _budget.value = desiredBudget
    }

    fun setTime(desiredTime: String) {
        _time.value = desiredTime
    }

    fun resetPref() {
        _dietary.value = arrayListOf()
        _calorie.value = "1000-1500"
        _macro.value = "40/30/30"
        _budget.value = "low"
        _time.value = "Less than 15min"
    }

}