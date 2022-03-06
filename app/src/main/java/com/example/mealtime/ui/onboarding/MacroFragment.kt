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
import com.example.mealtime.databinding.MacroFragmentBinding


class MacroFragment : Fragment() {

    private lateinit var binding: MacroFragmentBinding
    private val sharedViewModel: OnboardingViewModel by activityViewModels()

    val question = "What’s your macro diet preference (carbohydrates/protein/fat)?"
    val answers = listOf("40/30/30 macro split", "40/40/20 macro split", "50/30/20 macro split")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.macro_fragment, container, false)

        // Bind this fragment class to the layout
        binding.macro = this

        binding.nextButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->

            val checkedId = binding.macroQuestionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            var desiredMacro = answers[0]
            if (-1 != checkedId) {
                when (checkedId) {
                    R.id.Macro1RB -> desiredMacro = answers[0]
                    R.id.Macro2RB -> desiredMacro = answers[1]
                    R.id.Macro3RB -> desiredMacro = answers[2]
                }
            }

            Toast.makeText(activity,"Select $desiredMacro", Toast.LENGTH_SHORT).show()
            sharedViewModel.setMacro(desiredMacro)
            findNavController().navigate(R.id.action_macroFragment_to_budgetFragment)
        }

        return binding.root
    }
}