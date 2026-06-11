package com.university.listing.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.university.core.domain.model.University
import com.university.core.domain.usecase.GetUniversitiesUseCase
import com.university.core.util.Result
import com.university.listing.intent.ListingIntent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class ListingViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()
    private lateinit var useCase: GetUniversitiesUseCase
    private lateinit var viewModel: ListingViewModel

    private val sampleUniversities = listOf(
        University(
            name = "Abu Dhabi University",
            country = "United Arab Emirates",
            alphaTwoCode = "AE",
            stateProvince = "Abu Dhabi",
            domains = listOf("adu.ac.ae"),
            webPages = listOf("https://www.adu.ac.ae")
        ),
        University(
            name = "American University of Sharjah",
            country = "United Arab Emirates",
            alphaTwoCode = "AE",
            stateProvince = "Sharjah",
            domains = listOf("aus.edu"),
            webPages = listOf("https://www.aus.edu")
        )
    )

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        useCase = mock()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial load emits loading then success state`() = runTest {
        whenever(useCase(false)).thenReturn(Result.Success(sampleUniversities))

        viewModel = ListingViewModel(useCase)

        viewModel.state.test {
            val state = awaitItem()
            assertFalse(state.isLoading)
            assertEquals(sampleUniversities, state.universities)
            assertNull(state.error)
        }
    }

    @Test
    fun `initial load emits error state when use case fails`() = runTest {
        whenever(useCase(false)).thenReturn(Result.Error("Network unavailable"))

        viewModel = ListingViewModel(useCase)

        viewModel.state.test {
            val state = awaitItem()
            assertFalse(state.isLoading)
            assertTrue(state.universities.isEmpty())
            assertEquals("Network unavailable", state.error)
        }
    }

    @Test
    fun `RefreshUniversities intent triggers forceRefresh`() = runTest {
        whenever(useCase(false)).thenReturn(Result.Success(sampleUniversities))
        whenever(useCase(true)).thenReturn(Result.Success(sampleUniversities))

        viewModel = ListingViewModel(useCase)
        viewModel.processIntent(ListingIntent.RefreshUniversities)

        viewModel.state.test {
            val state = awaitItem()
            assertEquals(sampleUniversities, state.universities)
        }
    }

    @Test
    fun `SelectUniversity intent sets navigateToDetails`() = runTest {
        whenever(useCase(false)).thenReturn(Result.Success(sampleUniversities))

        viewModel = ListingViewModel(useCase)
        viewModel.processIntent(ListingIntent.SelectUniversity("Abu Dhabi University"))

        viewModel.state.test {
            val state = awaitItem()
            assertEquals("Abu Dhabi University", state.navigateToDetails?.name)
        }
    }

    @Test
    fun `onNavigationHandled clears navigateToDetails`() = runTest {
        whenever(useCase(false)).thenReturn(Result.Success(sampleUniversities))

        viewModel = ListingViewModel(useCase)
        viewModel.processIntent(ListingIntent.SelectUniversity("Abu Dhabi University"))
        viewModel.onNavigationHandled()

        viewModel.state.test {
            val state = awaitItem()
            assertNull(state.navigateToDetails)
        }
    }
}
