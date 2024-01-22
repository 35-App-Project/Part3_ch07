package com.choi.part3_ch07

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.choi.part3_ch07.model.ContentEntity
import com.choi.part3_ch07.repository.ContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// Input Activity 의 UI State 를 관리 하기 위한 ViewModel
@HiltViewModel
class InputViewModel @Inject constructor(
    private val contentRepository: ContentRepository
) : ViewModel() {

    // 입력이 완료 되었을 때 inputActivity를 닫기 위해 뷰모델에서 신호를 주기 위함
    private val _doneEvent = MutableLiveData<Unit>()
    val doEvent : LiveData<Unit> = _doneEvent

    var content = MutableLiveData<String>()
    var memo=MutableLiveData<String?>()

    fun insertData() {
        content.value?.let {content->
            viewModelScope.launch(Dispatchers.IO) {
                contentRepository.insert(
                    ContentEntity(content=content, memo=memo.value)
                )
                // postValue 로 main 스레드에 던져주기 위해
                _doneEvent.postValue(Unit)
            }
        }
    }

}