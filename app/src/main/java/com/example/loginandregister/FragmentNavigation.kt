package com.example.loginandregister

import androidx.fragment.app.Fragment

interface FragmentNavigation {
    fun navigateFrag(frag: Fragment, addToStack: Boolean)
}