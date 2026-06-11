package com.university.core.data.repository

import com.university.core.data.toDomain
import com.university.core.data.toEntity
import com.university.core.data.api.UniversityApiService
import com.university.core.data.db.UniversityDao
import com.university.core.domain.model.University
import com.university.core.util.Result
import javax.inject.Inject

class UniversityRepositoryImpl @Inject constructor(
    private val apiService: UniversityApiService,
    private val universityDao: UniversityDao
) : UniversityRepository {

    override suspend fun getUniversities(forceRefresh: Boolean): Result<List<University>> {
        return try {
            val remote = apiService.getUniversities()
            // Cache fresh data
            universityDao.deleteAll()
            universityDao.insertAll(remote.map { it.toEntity() })
            Result.Success(remote.map { it.toDomain() })
        } catch (e: Exception) {
            // Fallback to cache
            val cached = universityDao.getAllUniversities()
            if (cached.isNotEmpty()) {
                Result.Success(cached.map { it.toDomain() })
            } else {
                Result.Error(
                    message = e.message ?: "Unknown error occurred",
                    throwable = e
                )
            }
        }
    }
}
