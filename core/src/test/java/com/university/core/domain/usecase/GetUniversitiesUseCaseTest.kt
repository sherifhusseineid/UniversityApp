package com.university.core.domain.usecase

import com.university.core.data.repository.UniversityRepository
import com.university.core.domain.model.University
import com.university.core.util.Result
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class GetUniversitiesUseCaseTest {

    private lateinit var repository: UniversityRepository
    private lateinit var useCase: GetUniversitiesUseCase

    private val sampleUniversities = listOf(
        University(
            name = "Abu Dhabi University",
            country = "United Arab Emirates",
            alphaTwoCode = "AE",
            stateProvince = "Abu Dhabi",
            domains = listOf("adu.ac.ae"),
            webPages = listOf("https://www.adu.ac.ae")
        )
    )

    @Before
    fun setup() {
        repository = mock()
        useCase = GetUniversitiesUseCase(repository)
    }

    @Test
    fun `invoke returns success result from repository`() = runTest {
        whenever(repository.getUniversities(false)).thenReturn(Result.Success(sampleUniversities))

        val result = useCase(false)

        assertTrue(result is Result.Success)
        assertEquals(sampleUniversities, (result as Result.Success).data)
    }

    @Test
    fun `invoke with forceRefresh passes flag to repository`() = runTest {
        whenever(repository.getUniversities(true)).thenReturn(Result.Success(sampleUniversities))

        useCase(forceRefresh = true)

        verify(repository).getUniversities(true)
    }

    @Test
    fun `invoke returns error result from repository`() = runTest {
        whenever(repository.getUniversities(false)).thenReturn(Result.Error("Network error"))

        val result = useCase()

        assertTrue(result is Result.Error)
        assertEquals("Network error", (result as Result.Error).message)
    }
}
