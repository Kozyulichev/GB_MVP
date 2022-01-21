package com.example.gbmvp.domain.presenter

import com.example.gbmvp.domain.navigator.IScreens
import com.example.gbmvp.domain.view.MainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(private val router: Router, private val screens: IScreens) : MvpPresenter<MainView>() {

   override fun onFirstViewAttach() {
       super.onFirstViewAttach()
       router.replaceScreen(screens.auth())
   }

   fun backClicked() {
       router.exit()
   }
}

