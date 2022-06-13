package com.example.testproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.testproject.databinding.FragmentAuthorizationBinding
import com.example.testproject.ui.viewModels.AuthorizationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorizationFragment : Fragment() {
    private lateinit var viewBinding: FragmentAuthorizationBinding
    private val viewModel by lazy { ViewModelProvider(this).get(AuthorizationViewModel::class.java) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentAuthorizationBinding.inflate(inflater, container, false)

        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.auth()
        viewBinding.continueButtonView.setOnClickListener {
         //   viewModel.phone.value = viewBinding.inputPhoneEditText.text.toString()

        }
    }

}