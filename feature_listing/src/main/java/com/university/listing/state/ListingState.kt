package com.university.listing.state

import com.university.core.domain.model.University

data class ListingState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val universities: List<University> = emptyList(),
    val error: String? = null,
    val navigateToDetails: University? = null
)
