package com.university.details.state

import com.university.core.domain.model.University

data class DetailsState(
    val university: University? = null,
    val navigateBackWithRefresh: Boolean = false
)
