package com.example.gbmvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gbmvp.ButtonId.*
import com.example.gbmvp.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
lateinit var presenter2: MainPresenter

class MainActivity : AppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter2 = MainPresenter(this)

        initClickListeners()

    }

    private fun initClickListeners() {
        binding.btn1.setOnClickListener {
            presenter2.counterClick(BUTTON1)
        }
        binding.btn2.setOnClickListener {
            presenter2.counterClick(BUTTON2)
        }
        binding.btn3.setOnClickListener {
            presenter2.counterClick(BUTTON3)
        }
    }

    override fun setButtonText(buttonId: ButtonId, text: String) {
        when (buttonId) {
            BUTTON1 -> binding.btn1.text = text
            BUTTON2 -> binding.btn2.text = text
            BUTTON3 -> binding.btn3.text = text
        }
    }

}