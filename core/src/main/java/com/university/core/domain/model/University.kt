package com.university.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class University(
    val name: String,
    val country: String,
    val alphaTwoCode: String,
    val stateProvince: String,
    val domains: List<String>,
    val webPages: List<String>
) : Parcelable
