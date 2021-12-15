package com.example.gbmvp.domain.navigator

import com.example.gbmvp.presenation.LoginScreenFragment
import com.example.gbmvp.presenation.UserFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UserFragment.newInstance() }
    override fun loginScreen(login:String) = FragmentScreen { LoginScreenFragment.newInstance(login)}
}

