package com.example.main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.common.base_ui.BaseFragment
import com.example.thebestcurrency.R
import com.example.thebestcurrency.databinding.FragmentRegistrationPageBinding
import com.example.utils.extensions.replace

class RegistrationFragment : BaseFragment(R.layout.fragment_registration_page) {

    private lateinit var binding: FragmentRegistrationPageBinding

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
                if (loginEditText.text.toString().isEmpty()
                    && passwordEditText.text.toString().isEmpty()
                ) Toast.makeText(
                    context, "Password and Login fields are empty, fill it", Toast.LENGTH_LONG
                ).show()
                else if (loginEditText.text.toString().isEmpty()) Toast.makeText(
                    context, "Login field is empty", Toast.LENGTH_LONG
                ).show()
                else if(passwordEditText.text.toString().isEmpty()) Toast.makeText(
                    context,"Password field is empty, fill it",Toast.LENGTH_LONG
                ).show()
                else if(passwordEditText.text.length < 8
                    && loginEditText.text.length < 8) Toast.makeText(
                    context,"The minimum number of the Login and Password field characters is 8",Toast.LENGTH_LONG
                ).show()

                else if (passwordEditText.text.length < 8) Toast.makeText(
                    context,"The minimum number of the Password field characters is 8",Toast.LENGTH_LONG
                ).show()
                else if (loginEditText.text.length < 8) Toast.makeText(
                    context,"The minimum number of the Login field characters is 8",Toast.LENGTH_LONG
                ).show()
                else {
                    replace(CurrencyFragment.newInstance(), R.id.fragmentContainer)
                }
            }
        }
    }

}