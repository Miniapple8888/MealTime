package com.example.mealtime.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mealtime.R
import com.example.mealtime.databinding.CalorieFragmentBinding


class CalorieFragment : Fragment() {

    private lateinit var binding: CalorieFragmentBinding
    private val sharedViewModel: OnboardingViewModel by activityViewModels()

    val question = "What’s your daily calorie intake?"
    val answers = listOf("1000-1500", "1500-2000", "2000-2500", "2500-3000", "3000-3500")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.calorie_fragment, container, false)

        // Bind this fragment class to the layout
        binding.calorie = this

        binding.nextButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->

            val checkedId = binding.calorieQuestionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            var desiredCalorie = answers[0]
            if (-1 != checkedId) {
                when (checkedId) {
                    R.id.Calorie1RB -> desiredCalorie = answers[0]
                    R.id.Calorie2RB -> desiredCalorie = answers[1]
                    R.id.Calorie3RB -> desiredCalorie = answers[2]
                    R.id.Calorie4RB -> desiredCalorie = answers[3]
                    R.id.Calorie5RB -> desiredCalorie = answers[4]
                }
            }

            Toast.makeText(activity,"Select $desiredCalorie", Toast.LENGTH_SHORT).show()
            sharedViewModel.setCalorie(desiredCalorie)
            findNavController().navigate(R.id.action_calorieFragment_to_macroFragment)
        }
        return binding.root
    }
}