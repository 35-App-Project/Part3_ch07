package com.choi.part3_ch07

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.choi.part3_ch07.databinding.ActivityInputBinding
import com.choi.part3_ch07.model.ContentEntity
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

        (intent.getSerializableExtra(ITEM) as? ContentEntity)?.let {
            viewModel.initData(it)
        }

        // post 되면 이 부분이 호출 되고 finish() 를 통해 앱이 꺼진다 (옵저버로 관찰)
        viewModel.doEvent.observe(this) {
            Toast.makeText(this,"완료",Toast.LENGTH_SHORT)
                .show()
            finish()
        }
    }

    // HomeAsUp 눌렸을 때 이벤트
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        private const val ITEM="item"

        fun start (context: Context, item: ContentEntity?=null) {
            Intent(context,InputActivity::class.java).apply {
                putExtra(ITEM,item)
            }.run {
                context.startActivity(this)
            }
        }
    }

}