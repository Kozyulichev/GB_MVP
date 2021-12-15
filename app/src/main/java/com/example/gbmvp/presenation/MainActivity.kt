package com.example.gbmvp.presenation

import android.os.Bundle
import com.example.gbmvp.R
import com.example.gbmvp.SampleAppliaction
import com.example.gbmvp.databinding.MainActivityBinding
import com.example.gbmvp.domain.BackButtonListener
import com.example.gbmvp.domain.navigator.AndroidScreens
import com.example.gbmvp.domain.presenter.MainPresenter
import com.example.gbmvp.domain.view.MainView
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

private lateinit var binding: MainActivityBinding

class UsersActivity : MvpAppCompatActivity(R.layout.users_fragment), MainView {

    private val navigator = AppNavigator(this, R.id.container)

    private val presenter2 by moxyPresenter {
        MainPresenter( SampleAppliaction.INSTANCE.router, AndroidScreens())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        SampleAppliaction.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        SampleAppliaction.INSTANCE.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackButtonListener && it.backPressed()){
                return
            }
        }
        presenter2.backClicked()
    }


}