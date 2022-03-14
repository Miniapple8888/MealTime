package com.example.mealtime

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

/*
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
*/
/**
 * A simple [Fragment] subclass.
 * Use the [Login.newInstance] factory method to
 * create an instance of this fragment.
 */
class Login : Fragment() {
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
    }
*/
    private lateinit var email: EditText
    private lateinit var passwrd: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_login, container, false)

        email = view.findViewById(R.id.logEmail)
        passwrd = view.findViewById(R.id.logPassword)

        view.findViewById<Button>(R.id.logSignUpBtn).setOnClickListener {
            var navRegister = activity as FragmentNavigation
            navRegister.navigateFrag(Register(), false)
        }

        view.findViewById<Button>(R.id.logLoginBtn).setOnClickListener {
            validateEmptyForm()
        }

        return view
    }

    private fun validateEmptyForm() {
        when {
            TextUtils.isEmpty(email.text.toString().trim())->{
                email.error = "Please enter email"
            }
            TextUtils.isEmpty(passwrd.text.toString().trim())->{
                passwrd.error = "Please enter password"
            }

            email.text.toString().isNotEmpty() &&
                    passwrd.text.toString().isNotEmpty() -> {
                if (email.text.toString() matches (Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))) {

                } else {
                    email.error = "Please enter valid email address"
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
         * @return A new instance of fragment Login.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Login().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}*/
/*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var email = findViewById<TextView>(R.id.email)
        var password = findViewById<TextView>(R.id.password)

        var loginBtn = findViewById<Button>(R.id.loginBtn)

        loginBtn.setOnClickListener {
            val emailTxt = email.text
            val passwordTxt = password.text
            if (emailTxt.toString().equals("admin") && passwordTxt.toString().equals("1234")) {
                Toast.makeText(this@MainActivity, "LOGIN SUCCESS", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@MainActivity, "LOGIN FAIL", Toast.LENGTH_LONG).show()
            }
            // your code to validate the user_name and password combination
            // and verify the same
        }
    }
}
 */