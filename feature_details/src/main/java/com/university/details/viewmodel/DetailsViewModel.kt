package com.university.details.viewmodel

import androidx.lifecycle.ViewModel
import com.university.core.domain.model.University
import com.university.details.intent.DetailsIntent
import com.university.details.state.DetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(DetailsState())
    val state: StateFlow<DetailsState> = _state.asStateFlow()

    fun setUniversity(university: University) {
        _state.update { it.copy(university = university) }
    }

    fun processIntent(intent: DetailsIntent) {
        when (intent) {
            is DetailsIntent.Refresh -> {
                _state.update { it.copy(navigateBackWithRefresh = true) }
            }
        }
    }

    fun onNavigationHandled() {
        _state.update { it.copy(navigateBackWithRefresh = false) }
    }
}
