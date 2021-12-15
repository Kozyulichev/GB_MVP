package com.example.gbmvp.domain.view

import moxy.MvpView
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SkipStrategy::class)
interface LoginScreenView : MvpView {
    fun setText(text: String)
}