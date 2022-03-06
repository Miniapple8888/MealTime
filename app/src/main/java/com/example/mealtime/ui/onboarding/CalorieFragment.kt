package com.example.mealtime.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mealtime.R
import com.example.mealtime.databinding.CalorieFragmentBinding


class CalorieFragment : Fragment() {

    val question = "What’s your daily calorie intake?"
    val answers = listOf("1000-1500", "1500-2000", "2000-2500", "2500-3000", "3000-3500")

    private var binding: CalorieFragmentBinding? = null

    // Use the 'by activityViewModels()' Kotlin property delegate from the fragment-ktx artifact
    private val sharedViewModel: OnboardingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = CalorieFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            // Specify the fragment as the lifecycle owner
            lifecycleOwner = viewLifecycleOwner

            // Assign the view model to a property in the binding class
            viewModel = sharedViewModel

            // Assign the fragment
            calorie = this@CalorieFragment
        }
    }

    /**
     * Navigate to the next screen to choose pickup date.
     */
    fun goToNextScreen() {
        findNavController().navigate(R.id.action_calorieFragment_to_macroFragment)
    }

    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}