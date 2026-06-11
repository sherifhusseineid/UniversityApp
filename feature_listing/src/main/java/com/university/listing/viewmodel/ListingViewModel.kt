package com.university.listing.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.university.core.domain.usecase.GetUniversitiesUseCase
import com.university.core.util.Result
import com.university.listing.intent.ListingIntent
import com.university.listing.state.ListingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListingViewModel @Inject constructor(
    private val getUniversitiesUseCase: GetUniversitiesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ListingState())
    val state: StateFlow<ListingState> = _state.asStateFlow()

    init {
        processIntent(ListingIntent.LoadUniversities)
    }

    fun processIntent(intent: ListingIntent) {
        when (intent) {
            is ListingIntent.LoadUniversities -> loadUniversities(forceRefresh = false)
            is ListingIntent.RefreshUniversities -> loadUniversities(forceRefresh = true)
            is ListingIntent.SelectUniversity -> {
                val university = _state.value.universities.find { it.name == intent.universityName }
                _state.update { it.copy(navigateToDetails = university) }
            }
        }
    }

    fun onNavigationHandled() {
        _state.update { it.copy(navigateToDetails = null) }
    }

    private fun loadUniversities(forceRefresh: Boolean) {
        viewModelScope.launch {
            if (forceRefresh) {
                // Pull-to-refresh: keep existing list visible, show spinner on top
                _state.update { it.copy(isRefreshing = true, error = null) }
            } else {
                // Initial load: show full-screen loading spinner
                _state.update { it.copy(isLoading = true, error = null) }
            }

            when (val result = getUniversitiesUseCase(forceRefresh)) {
                is Result.Success -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            isRefreshing = false,
                            universities = result.data,
                            error = null
                        )
                    }
                }
                is Result.Error -> {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            isRefreshing = false,
                            error = result.message
                        )
                    }
                }
                is Result.Loading -> Unit
            }
        }
    }
}