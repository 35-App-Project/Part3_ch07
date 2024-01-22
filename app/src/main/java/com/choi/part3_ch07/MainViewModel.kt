package com.choi.part3_ch07

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.choi.part3_ch07.repository.ContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val contentRepository: ContentRepository) :
    ViewModel() {

    // 지속적 구독
    val  contentList= contentRepository.loadList()
            .stateIn(
                initialValue = emptyList(),
                started = SharingStarted.WhileSubscribed(5000),
                scope = viewModelScope
            )

}