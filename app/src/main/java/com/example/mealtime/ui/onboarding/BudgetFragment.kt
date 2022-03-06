package com.example.mealtime.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mealtime.R
import com.example.mealtime.databinding.BudgetFragmentBinding


class BudgetFragment : Fragment() {

    private lateinit var binding: BudgetFragmentBinding
    private val sharedViewModel: OnboardingViewModel by activityViewModels()

    val question = "What’s your budget every day?"
    val answers = listOf("Cheap, please (<15\$)", "Comfortable with spending more (<30\$)", "I got the money (30\$+)")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.budget_fragment, container, false)

        // Bind this fragment class to the layout
        binding.budget = this

        binding.nextButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->

            val checkedId = binding.budgetQuestionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            var desiredBudget = answers[0]
            if (-1 != checkedId) {
                when (checkedId) {
                    R.id.Budget1RB -> desiredBudget = answers[0]
                    R.id.Budget2RB -> desiredBudget = answers[1]
                    R.id.Budget3RB -> desiredBudget = answers[2]
                }
            }

            sharedViewModel.setBudget(desiredBudget)
            findNavController().navigate(R.id.action_budgetFragment_to_timeFragment)
        }

        return binding.root
    }
}