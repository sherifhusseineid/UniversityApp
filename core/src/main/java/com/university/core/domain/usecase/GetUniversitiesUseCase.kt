package com.university.core.domain.usecase

import com.university.core.data.repository.UniversityRepository
import com.university.core.domain.model.University
import com.university.core.util.Result
import javax.inject.Inject

class GetUniversitiesUseCase @Inject constructor(
    private val repository: UniversityRepository
) {
    suspend operator fun invoke(forceRefresh: Boolean = false): Result<List<University>> {
        return repository.getUniversities(forceRefresh)
    }
}
