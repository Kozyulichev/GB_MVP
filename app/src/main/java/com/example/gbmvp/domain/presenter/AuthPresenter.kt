package com.example.gbmvp.domain.presenter

import com.example.gbmvp.domain.navigator.AndroidScreens
import com.example.gbmvp.domain.view.AuthView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class AuthPresenter(private val router: Router) : MvpPresenter<AuthView>() {

    fun navigateToUsersScreen(login: String, password: String) {
        router.replaceScreen(AndroidScreens().users(login, password))
    }
}