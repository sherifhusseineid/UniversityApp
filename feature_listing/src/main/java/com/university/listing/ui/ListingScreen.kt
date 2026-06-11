package com.university.listing.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.university.core.domain.model.University
import com.university.listing.R
import com.university.listing.intent.ListingIntent
import com.university.listing.viewmodel.ListingViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListingScreen(
    onNavigateToDetails: (University) -> Unit,
    viewModel: ListingViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val pullToRefreshState = rememberPullToRefreshState()

    // Handle navigation side effect
    LaunchedEffect(state.navigateToDetails) {
        state.navigateToDetails?.let { university ->
            onNavigateToDetails(university)
            viewModel.onNavigationHandled()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("UAE Universities") },
                actions = {
                    IconButton(
                        onClick = {
                            viewModel.processIntent(ListingIntent.RefreshUniversities)
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_refresh),
                            contentDescription = "Refresh"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                // Initial load — full screen spinner
                state.isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                // Error with no cached data — full error screen
                state.error != null && state.universities.isEmpty() -> {
                    ErrorContent(
                        message = state.error!!,
                        onRetry = {
                            viewModel.processIntent(ListingIntent.RefreshUniversities)
                        },
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                // Data available — list with pull-to-refresh
                else -> {
                    PullToRefreshBox(
                        isRefreshing = state.isRefreshing,
                        onRefresh = {
                            viewModel.processIntent(ListingIntent.RefreshUniversities)
                        },
                        state = pullToRefreshState,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        if (state.universities.isEmpty() && !state.isRefreshing) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "No universities found",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        } else {
                            UniversityList(
                                universities = state.universities,
                                onUniversityClick = { university ->
                                    viewModel.processIntent(
                                        ListingIntent.SelectUniversity(university.name)
                                    )
                                }
                            )
                        }

                        // Snackbar when refresh fails but cached data exists
                        if (state.error != null && state.universities.isNotEmpty()) {
                            Snackbar(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(16.dp),
                                action = {
                                    TextButton(
                                        onClick = {
                                            viewModel.processIntent(
                                                ListingIntent.RefreshUniversities
                                            )
                                        }
                                    ) {
                                        Text("Retry")
                                    }
                                }
                            ) {
                                Text("Failed to refresh. Showing cached data.")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun UniversityList(
    universities: List<University>,
    onUniversityClick: (University) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(universities, key = { it.name }) { university ->
            UniversityItem(
                university = university,
                onClick = { onUniversityClick(university) }
            )
            HorizontalDivider()
        }
    }
}

@Composable
private fun UniversityItem(
    university: University,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = university.name,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            softWrap = true
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = university.country,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        if (!university.stateProvince.isNullOrBlank()) {
            Text(
                text = university.stateProvince,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun ErrorContent(
    message: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Failed to load universities",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onRetry) {
            Text("Retry")
        }
    }
}