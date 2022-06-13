package com.example.testproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.testproject.R
import com.example.testproject.databinding.FragmentAboutClientBinding
import com.example.testproject.ui.viewModels.AboutClientViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutClientFragment : Fragment() {
    private lateinit var dataBinding: FragmentAboutClientBinding
    private val viewModel by lazy { ViewModelProvider(this).get(AboutClientViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_about_client, container, false)
        dataBinding.lifecycleOwner = this
        dataBinding.viewModel = viewModel
        return dataBinding.root
    }



}