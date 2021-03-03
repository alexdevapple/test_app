package com.alex.ui.mainflow.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.alex.R
import com.alex.databinding.FragmentLoginBinding
import com.alex.ui.base.BaseFragment
import com.alex.utils.makeSnackbar

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentLoginBinding.bind(view)
        binding.loginButton.setOnClickListener {
            val emailStr = binding.emailEditText.text.toString().trim()
            val passwordStr = binding.passwordEditText.text.toString().trim()
            viewModel.login(emailStr, passwordStr)
        }

        viewModel.isLoading.observe(viewLifecycleOwner, { isLoading ->
            binding.loginButton.isEnabled = !isLoading
        })
        viewModel.error.observe(viewLifecycleOwner, { errorStr ->
            binding.root.makeSnackbar(errorStr).show()
        })
        viewModel.result.observe(viewLifecycleOwner, { errorStr ->
            binding.root.makeSnackbar(errorStr).show()
        })
    }
}