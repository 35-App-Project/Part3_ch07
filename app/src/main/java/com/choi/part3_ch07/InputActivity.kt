package com.choi.part3_ch07

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.choi.part3_ch07.databinding.ActivityInputBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInputBinding

    private val viewModel : InputViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInputBinding.inflate(layoutInflater).apply {
            setContentView(root)
            lifecycleOwner=this@InputActivity
            viewModel=this@InputActivity.viewModel
        }
        /* 액션 바의 뒤로 가기 버튼 보임 */
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // post 되면 이 부분이 호출 되고 finish() 를 통해 앱이 꺼진다
        viewModel.doEvent.observe(this) {
            Toast.makeText(this,"완료",Toast.LENGTH_SHORT)
                .show()
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}