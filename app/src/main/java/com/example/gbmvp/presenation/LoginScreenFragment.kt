package com.example.gbmvp.presenation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gbmvp.R
import com.example.gbmvp.databinding.FragmentLoginScreenBinding
import com.example.gbmvp.domain.model.GithubUser
import com.example.gbmvp.domain.presenter.LoginScreenPresenter
import com.example.gbmvp.domain.view.LoginScreenView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class LoginScreenFragment(private val userLogin: String) :
    MvpAppCompatFragment(R.layout.fragment_login_screen), LoginScreenView {

    private val presenter by moxyPresenter {
        LoginScreenPresenter(GithubUser((userLogin)))
    }

    private lateinit var binding: FragmentLoginScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginScreenBinding.inflate(inflater, container, false)
        presenter.showUserLogin(userLogin)
        return binding.root
    }

    override fun setText(text: String) {
        binding.tv1.text = text
    }
}