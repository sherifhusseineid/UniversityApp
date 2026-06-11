package com.university.core.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "universities")
data class UniversityEntity(
    @PrimaryKey
    val name: String,
    val country: String,
    val alphaTwoCode: String,
    val stateProvince: String?,
    val domains: String,   // JSON string
    val webPages: String   // JSON string
)
