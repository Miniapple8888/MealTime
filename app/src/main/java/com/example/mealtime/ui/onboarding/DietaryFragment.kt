package com.example.mealtime.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.mealtime.R
import com.example.mealtime.databinding.DietaryFragmentBinding
import androidx.fragment.app.activityViewModels

class DietaryFragment : Fragment() {

    private lateinit var binding: DietaryFragmentBinding
    private val sharedViewModel: OnboardingViewModel by activityViewModels()

    val question = "Enter your dietary restriction: "
    val answers = listOf("Lactose-free", "Nut free", "Keto diet", "Halal", "Seafood free", "Gluten free")

    var finalDietary: ArrayList<String> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.dietary_fragment, container, false)

        // Bind this fragment class to the layout
        binding.dietary = this

        binding.Dietary1CB.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                if (!finalDietary.contains(answers[0]))
                    finalDietary.add(answers[0])
            else finalDietary.remove(answers[0])
        }
        binding.Dietary2CB.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                if (!finalDietary.contains(answers[1]))
                    finalDietary.add(answers[1])
            else finalDietary.remove(answers[1])
        }
        binding.Dietary3CB.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                if (!finalDietary.contains(answers[2]))
                    finalDietary.add(answers[2])
            else finalDietary.remove(answers[2])
        }
        binding.Dietary4CB.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                if (!finalDietary.contains(answers[3]))
                    finalDietary.add(answers[3])
            else finalDietary.remove(answers[3])
        }
        binding.Dietary5CB.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                if (!finalDietary.contains(answers[4]))
                    finalDietary.add(answers[4])
            else finalDietary.remove(answers[4])
        }
        binding.Dietary6CB.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                if (!finalDietary.contains(answers[5]))
                    finalDietary.add(answers[5])
            else finalDietary.remove(answers[5])
        }

        binding.nextButton.setOnClickListener { chooseDietary() }

        return binding.root
    }

    fun chooseDietary() {

        sharedViewModel.setDietary(finalDietary)
        finalDietary.clear()
        findNavController().navigate(R.id.action_dietaryFragment_to_calorieFragment)

    }
}