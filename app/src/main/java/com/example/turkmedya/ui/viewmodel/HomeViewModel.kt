package com.example.turkmedya.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.turkmedya.domain.model.FilteredNews
import com.example.turkmedya.domain.usecase.FetchNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val fetchNewsUseCase: FetchNewsUseCase):ViewModel() {
    private val _itemList = MutableLiveData<List<FilteredNews>>()
    val itemList: LiveData<List<FilteredNews>> get() = _itemList
    init {
        fetchNews()
    }
    fun fetchNews() {
        viewModelScope.launch {
            val result = fetchNewsUseCase.execute()
            result.onSuccess { data ->
                _itemList.value = data
                Log.d("NewsViewModel", "Item List: ${data}")
            }.onFailure { exception ->
                Log.e("NewsViewModel", "Error: ${exception}")
            }
        }
    }

}
