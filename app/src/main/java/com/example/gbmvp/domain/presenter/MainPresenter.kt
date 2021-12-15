package com.example.gbmvp.domain.presenter

import com.example.gbmvp.domain.navigator.IScreens
import com.example.gbmvp.domain.view.MainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {

   override fun onFirstViewAttach() {
       super.onFirstViewAttach()
       router.replaceScreen(screens.users())
   }

   fun backClicked() {
       router.exit()
   }
}

