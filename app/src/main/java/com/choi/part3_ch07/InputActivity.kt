package com.choi.part3_ch07

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.choi.part3_ch07.databinding.ActivityInputBinding


class InputActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInputBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }
        /* 액션 바의 뒤로 가기 버튼 보임 */
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}