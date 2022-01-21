package com.example.gbmvp.domain.presenter

import com.example.gbmvp.domain.model.GithubUser
import com.example.gbmvp.domain.view.LoginScreenView
import moxy.MvpPresenter

class LoginScreenPresenter(private val githubUser: GithubUser) : MvpPresenter<LoginScreenView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setText(githubUser.login)
    }

    fun showUserLogin(login:String){
        viewState.setText(login)
    }

}