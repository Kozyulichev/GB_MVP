package com.example.gbmvp.domain.presenter

import com.example.gbmvp.domain.view.SampleView
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import moxy.MvpPresenter

class SamplePresenter(
    private val router: Router
) : MvpPresenter<SampleView>() {

    fun onOpenNewScreen(screen: Screen) {
        router.navigateTo(screen)
    }

    fun onBackPressed() {
        router.exit()
    }
}