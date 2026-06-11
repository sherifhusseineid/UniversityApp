package com.university.core.data.repository

import com.university.core.data.api.UniversityApiService
import com.university.core.data.api.UniversityDto
import com.university.core.data.db.UniversityDao
import com.university.core.data.db.UniversityEntity
import com.university.core.util.Result
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class UniversityRepositoryImplTest {

    private lateinit var apiService: UniversityApiService
    private lateinit var dao: UniversityDao
    private lateinit var repository: UniversityRepositoryImpl

    private val dtoList = listOf(
        UniversityDto(
            name = "Abu Dhabi University",
            country = "United Arab Emirates",
            alphaTwoCode = "AE",
            stateProvince = "Abu Dhabi",
            domains = listOf("adu.ac.ae"),
            webPages = listOf("https://www.adu.ac.ae")
        )
    )

    private val entityList = listOf(
        UniversityEntity(
            name = "Abu Dhabi University",
            country = "United Arab Emirates",
            alphaTwoCode = "AE",
            stateProvince = "Abu Dhabi",
            domains = """["adu.ac.ae"]""",
            webPages = """["https://www.adu.ac.ae"]"""
        )
    )

    @Before
    fun setup() {
        apiService = mock()
        dao = mock()
        repository = UniversityRepositoryImpl(apiService, dao)
    }

    @Test
    fun `getUniversities returns success from API and caches data`() = runTest {
        whenever(apiService.getUniversities(any())).thenReturn(dtoList)

        val result = repository.getUniversities()

        assertTrue(result is Result.Success)
        assertEquals("Abu Dhabi University", (result as Result.Success).data[0].name)
        verify(dao).deleteAll()
        verify(dao).insertAll(any())
    }

    @Test
    fun `getUniversities returns cached data on API failure`() = runTest {
        whenever(apiService.getUniversities(any())).thenThrow(RuntimeException("Network error"))
        whenever(dao.getAllUniversities()).thenReturn(entityList)

        val result = repository.getUniversities()

        assertTrue(result is Result.Success)
        assertEquals("Abu Dhabi University", (result as Result.Success).data[0].name)
    }

    @Test
    fun `getUniversities returns error when API fails and cache is empty`() = runTest {
        whenever(apiService.getUniversities(any())).thenThrow(RuntimeException("Network error"))
        whenever(dao.getAllUniversities()).thenReturn(emptyList())

        val result = repository.getUniversities()

        assertTrue(result is Result.Error)
    }
}
