package com.example.gbmvp.domain.navigator

import com.github.terrakok.cicerone.Screen

interface IScreens {
   fun users(): Screen
   fun loginScreen(login:String):Screen
}
