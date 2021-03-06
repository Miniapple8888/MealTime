package com.example.mealtime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.mealtime.databinding.MainActivityBinding
import com.example.mealtime.FragmentNavigation

class MainActivity : AppCompatActivity(), FragmentNavigation {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)
        val navController = this.findNavController(R.id.onboardingNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
        supportFragmentManager.beginTransaction()
            .add(R.id.container, Login())
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.onboardingNavHostFragment)
        return navController.navigateUp()
    }

    override fun navigateFrag(frag: Fragment, addToStack: Boolean) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, frag)

        if (addToStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }
}
