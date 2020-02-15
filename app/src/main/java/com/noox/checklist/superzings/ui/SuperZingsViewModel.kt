package com.noox.checklist.superzings.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noox.checklist.core.model.SuperZing
import com.noox.checklist.superzings.data.SuperZingsRepository
import kotlinx.coroutines.launch
import com.noox.checklist.core.Result
import com.noox.checklist.superzings.ui.SuperZingsViewModel.ViewState.Error
import com.noox.checklist.superzings.ui.SuperZingsViewModel.ViewState.Loading
import com.noox.checklist.superzings.ui.SuperZingsViewModel.ViewState.Success

class SuperZingsViewModel(
    private val repository: SuperZingsRepository
) : ViewModel() {

    private val _state = MutableLiveData<ViewState>()

    val state: LiveData<ViewState> = _state

    init {
        viewModelScope.launch {
            post(viewState = Loading)
            when (val result= repository.load()) {
                is Result.Success -> { post(viewState = Success(result.data)) }
                is Result.Error -> { post(viewState = Error) }
            }
        }
    }

    private fun post(viewState: ViewState) {
        _state.value = viewState
    }

    sealed class ViewState {
        object Loading : ViewState()
        class Success(val items: List<SuperZing>): ViewState()
        object Error: ViewState()
    }

}
