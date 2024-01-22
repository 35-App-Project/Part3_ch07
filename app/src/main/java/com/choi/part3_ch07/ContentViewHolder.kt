package com.choi.part3_ch07

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.choi.part3_ch07.databinding.ItemContentBinding
import com.choi.part3_ch07.model.ContentEntity

// RecyclerView 뷰 홀더
class ContentViewHolder(private val binding: ItemContentBinding,
    private val handler: MainActivity.Handler?=null) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item : ContentEntity) {
        binding.item=item
        binding.handler=handler

        binding.contentCheckBox.paintFlags = if (item.isDone) {
            binding.contentCheckBox.paintFlags + Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            0
        }
    }
}
