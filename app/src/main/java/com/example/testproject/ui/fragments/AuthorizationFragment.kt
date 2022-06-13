package com.example.testproject.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testproject.R
import com.example.testproject.databinding.FragmentAuthorizationBinding
import com.example.testproject.enums.EResultType
import com.example.testproject.ui.viewModels.AuthorizationViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AuthorizationFragment : Fragment() {
    private lateinit var dataBinding: FragmentAuthorizationBinding
    private val viewModel by lazy { ViewModelProvider(this).get(AuthorizationViewModel::class.java) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_authorization, container, false)
        dataBinding.lifecycleOwner = this
        dataBinding.viewModel = viewModel

        initListeners()
        return dataBinding.root
    }

    private fun initListeners() {
        dataBinding.continueButtonView.setOnClickListener {
            val pass = dataBinding.inputPasswordEditText.text.toString()
            val phone = dataBinding.inputPhoneEditText.text.toString()

            if (viewModel.setValues(pass = pass, phone = phone)) {
                viewModel.auth()
            } else {
                context?.toast(getString(R.string.error_input_message))
            }
        }

        viewModel.resultType.observe(viewLifecycleOwner) {
            when (it) {
                EResultType.SUCCESS -> this.findNavController()
                    .navigate(R.id.action_authorizationFragment_to_aboutClientFragment)
                EResultType.ERROR -> context?.toast(getString(R.string.error_message))
                else -> {}
            }
        }
    }

    private fun Context.toast(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}