package com.choi.part3_ch07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.choi.part3_ch07.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            view = this@MainActivity

        }
    }

    fun onClickAdd() {

    }

}