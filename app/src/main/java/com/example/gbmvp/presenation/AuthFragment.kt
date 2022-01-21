package com.example.gbmvp.presenation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gbmvp.R
import com.example.gbmvp.SampleAppliaction
import com.example.gbmvp.databinding.FragmentAuthBinding
import com.example.gbmvp.domain.presenter.AuthPresenter
import com.example.gbmvp.domain.view.AuthView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class AuthFragment : MvpAppCompatFragment(R.layout.fragment_auth),AuthView {

    private lateinit var binding: FragmentAuthBinding

    private val presenter by moxyPresenter {
        AuthPresenter(SampleAppliaction.INSTANCE.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.enter.setOnClickListener {
            val password = binding.password.text.toString()
            val login = binding.login.text.toString()
            presenter.navigateToUsersScreen(login, password)
        }
    }
}