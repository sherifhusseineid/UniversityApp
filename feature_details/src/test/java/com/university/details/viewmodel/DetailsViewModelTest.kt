package com.university.details.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.university.core.domain.model.University
import com.university.details.intent.DetailsIntent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DetailsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()
    private lateinit var viewModel: DetailsViewModel

    private val sampleUniversity = University(
        name = "Abu Dhabi University",
        country = "United Arab Emirates",
        alphaTwoCode = "AE",
        stateProvince = "Abu Dhabi",
        domains = listOf("adu.ac.ae"),
        webPages = listOf("https://www.adu.ac.ae")
    )

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = DetailsViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `setUniversity updates state with university`() = runTest {
        viewModel.setUniversity(sampleUniversity)

        viewModel.state.test {
            val state = awaitItem()
            assertEquals(sampleUniversity, state.university)
            assertFalse(state.navigateBackWithRefresh)
        }
    }

    @Test
    fun `Refresh intent sets navigateBackWithRefresh to true`() = runTest {
        viewModel.setUniversity(sampleUniversity)
        viewModel.processIntent(DetailsIntent.Refresh)

        viewModel.state.test {
            val state = awaitItem()
            assertTrue(state.navigateBackWithRefresh)
        }
    }

    @Test
    fun `onNavigationHandled resets navigateBackWithRefresh`() = runTest {
        viewModel.setUniversity(sampleUniversity)
        viewModel.processIntent(DetailsIntent.Refresh)
        viewModel.onNavigationHandled()

        viewModel.state.test {
            val state = awaitItem()
            assertFalse(state.navigateBackWithRefresh)
        }
    }

    @Test
    fun `initial state has no university and no navigation flag`() = runTest {
        viewModel.state.test {
            val state = awaitItem()
            assertNull(state.university)
            assertFalse(state.navigateBackWithRefresh)
        }
    }
}
