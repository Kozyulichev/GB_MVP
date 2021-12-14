package com.example.gbmvp

import com.example.gbmvp.ButtonId.*

class MainPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun counterClick(buttonId: ButtonId) {
        when (buttonId) {
            BUTTON1 -> view.setButtonText(BUTTON1, model.next(0).toString())
            BUTTON2 -> view.setButtonText(BUTTON2, model.next(1).toString())
            BUTTON3 -> view.setButtonText(BUTTON3, model.next(2).toString())
        }
    }
}

enum class ButtonId {
    BUTTON1, BUTTON2, BUTTON3
}