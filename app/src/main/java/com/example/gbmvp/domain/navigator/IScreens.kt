package com.example.gbmvp.domain.navigator

import com.github.terrakok.cicerone.Screen

interface IScreens {
   fun auth():Screen
   fun users(login: String,password:String): Screen
   fun loginScreen(login:String):Screen
}
