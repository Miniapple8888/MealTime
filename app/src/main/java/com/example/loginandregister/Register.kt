package com.example.loginandregister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.text.TextUtils

/*
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
*/
/**
 * A simple [Fragment] subclass.
 * Use the [Register.newInstance] factory method to
 * create an instance of this fragment.
 */
class Register : Fragment() {
    /*
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }*/

    private lateinit var firstName: EditText
    private lateinit var email: EditText
    private lateinit var passwrd: EditText
    private lateinit var cnfPassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_register, container, false)

        firstName = view.findViewById(R.id.regFirstName)
        email = view.findViewById(R.id.regEmail)
        passwrd = view.findViewById(R.id.regPassword)
        cnfPassword = view.findViewById(R.id.regConfirmPassword)

        view.findViewById<Button>(R.id.regLoginBtn).setOnClickListener {
            var navRegister = activity as FragmentNavigation
            navRegister.navigateFrag(Login(), false)
        }

        view.findViewById<Button>(R.id.regSignupBtn).setOnClickListener {
            validateEmptyForm()
        }
        return view
    }
    private fun validateEmptyForm() {
        when {
            TextUtils.isEmpty(firstName.text.toString().trim())->{
                firstName.error = "Please enter first name"
            }
            TextUtils.isEmpty(email.text.toString().trim())->{
                email.error = "Please enter email"
            }
            TextUtils.isEmpty(passwrd.text.toString().trim())->{
                passwrd.error = "Please enter password"
            }
            TextUtils.isEmpty(cnfPassword.text.toString().trim())->{
                cnfPassword.error = "Please enter confirm password"
            }

            email.text.toString().isNotEmpty() &&
            passwrd.text.toString().isNotEmpty() &&
            cnfPassword.text.toString().isNotEmpty() -> {
                if (email.text.toString() matches (Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+(\\s*)"))) {
                    if (passwrd.text.toString().length >= 5) {
                        if (passwrd.text.toString() == cnfPassword.text.toString()) {
                            Toast.makeText(context, "Sign up success!", Toast.LENGTH_LONG).show()
                        } else {
                            cnfPassword.setError("Passwords do not match")
                        }
                    } else {
                        passwrd.setError("Please enter valid password (at least 5 characters)")
                    }
                } else {
                    email.setError("Please enter valid email address")
                }
            }
        }
    }
}
/*
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Register.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Register().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}*/