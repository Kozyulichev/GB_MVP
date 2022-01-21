package com.example.gbmvp.domain.view

import moxy.MvpView
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState

interface LoginScreenView : MvpView {
    @SingleState
    fun setText(text: String)
}