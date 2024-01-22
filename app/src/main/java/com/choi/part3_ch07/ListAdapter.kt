package com.choi.part3_ch07

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.choi.part3_ch07.databinding.ItemContentBinding
import com.choi.part3_ch07.model.ContentEntity

class ListAdapter : ListAdapter<ContentEntity, ContentViewHolder>(diffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        return ContentViewHolder(
            ItemContentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffCallBack = object : DiffUtil.ItemCallback<ContentEntity>() {
            override fun areItemsTheSame(oldItem: ContentEntity, newItem: ContentEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ContentEntity,
                newItem: ContentEntity
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}