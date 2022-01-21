package com.example.gbmvp.presenation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gbmvp.R
import com.example.gbmvp.SampleAppliaction
import com.example.gbmvp.data.GitHubRepositoryImpl
import com.example.gbmvp.databinding.UsersFragmentBinding
import com.example.gbmvp.domain.BackButtonListener
import com.example.gbmvp.domain.presenter.UsersPresenter
import com.example.gbmvp.domain.view.UsersView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment(private val userLogin: String, private val userPassword: String) :
    MvpAppCompatFragment(R.layout.users_fragment), UsersView, BackButtonListener {

    private lateinit var binding: UsersFragmentBinding


    private val presenter2 by moxyPresenter {
        UsersPresenter(GitHubRepositoryImpl(), SampleAppliaction.INSTANCE.router)
    }

    private var adapter: UsersRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = UsersFragmentBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (userLogin != null && userPassword != null) {
            binding.login.text = userLogin
            binding.password.text = userPassword
        }
        init()
    }


    override fun init() {
        binding.recycler.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter2.usersListPresenter)
        binding.recycler.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed(): Boolean = presenter2.backPressed()


}