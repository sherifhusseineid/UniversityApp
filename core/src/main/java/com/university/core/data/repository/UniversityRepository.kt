package com.university.core.data.repository

import com.university.core.domain.model.University
import com.university.core.util.Result

interface UniversityRepository {
    suspend fun getUniversities(forceRefresh: Boolean = false): Result<List<University>>
}
