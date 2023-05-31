package com.example.login_registration_ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.common.base_ui.BaseFragment
import com.example.main_page.ui.CurrencyFragment
import com.example.thebestcurrency.R
import com.example.thebestcurrency.databinding.FragmentRegistrationPageBinding
import com.example.utils.extensions.replace
import com.google.firebase.auth.FirebaseAuth
import timber.log.Timber

class RegistrationFragment : BaseFragment(R.layout.fragment_registration_page) {

    private lateinit var binding: FragmentRegistrationPageBinding
    private var email: String = ""
    private var password: String = ""
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            registrationBtn.setOnClickListener {
                progressBar.isVisible = true
                email = loginEditText.text.toString()
                password = passwordEditText.text.toString()
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(context, "Enter email", Toast.LENGTH_SHORT).show()
                    progressBar.isVisible = false
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(context, "Enter password", Toast.LENGTH_SHORT).show()
                    progressBar.isVisible = false
                } else {
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            progressBar.isVisible = false
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Timber.d("createUserWithEmail:success")
                                Toast.makeText(
                                    context,
                                    "Account created.",
                                    Toast.LENGTH_SHORT,
                                ).show()
                                replace(CurrencyFragment.newInstance(), R.id.fragmentContainer)
                            } else {
                                // If sign in fails, display a message to the user.
                                Timber.e("createUserWithEmail:failure", task.exception)
                                if (!email.contains("@gmail.com")) {
                                    Toast.makeText(
                                        context,
                                        "This email does not exist.",
                                        Toast.LENGTH_SHORT,
                                    ).show()
                                } else if (email.contains("@gmail.com")) {
                                    Toast.makeText(
                                        context,
                                        "This email is occupied.",
                                        Toast.LENGTH_SHORT,
                                    ).show()
                                } else  Toast.makeText(
                                    context,
                                    "Authentication is failed.",
                                    Toast.LENGTH_SHORT,
                                ).show()
                            }
                        }
                }
            }
            loginTextView.setOnClickListener {
                replace(LoginFragment(), R.id.fragmentContainer)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            replace(CurrencyFragment.newInstance(), R.id.fragmentContainer)
        }
    }
}