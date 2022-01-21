package com.example.gbmvp.domain.navigator

import com.example.gbmvp.presenation.AuthFragment
import com.example.gbmvp.presenation.LoginScreenFragment
import com.example.gbmvp.presenation.UserFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun auth() = FragmentScreen{ AuthFragment()}
    override fun users(login: String,password:String) = FragmentScreen { UserFragment(login,password) }
    override fun loginScreen(login:String) = FragmentScreen { LoginScreenFragment(login)}
}

