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
import com.example.mealtime.databinding.TimeFragmentBinding


class TimeFragment : Fragment() {

    private lateinit var binding: TimeFragmentBinding
    private val sharedViewModel: OnboardingViewModel by activityViewModels()

    val question = "How much time do you have to spend prepping your meals?"
    val answers = listOf("Less than 15 min", "Less than 30 min", "Less than 1 hour", "More than 1 hour")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.time_fragment, container, false)

        // Bind this fragment class to the layout
        binding.time = this

        binding.generateButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->

            val checkedId = binding.timeQuestionRadioGroup.checkedRadioButtonId

            var desiredTime = answers[0]
            if (-1 != checkedId) {
                when (checkedId) {
                    R.id.Time1RB -> desiredTime = answers[0]
                    R.id.Time2RB -> desiredTime = answers[1]
                    R.id.Time3RB -> desiredTime = answers[2]
                    R.id.Time4RB -> desiredTime = answers[3]
                }
            }

            sharedViewModel.setTime(desiredTime)
            findNavController().navigate(R.id.action_timeFragment_to_settingFragment)
        }

        return binding.root
    }
}