package com.university.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.MaterialTheme
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.university.app.navigation.Screen
import com.university.core.domain.model.University
import com.university.details.ui.DetailsActivity
import com.university.listing.intent.ListingIntent
import com.university.listing.ui.ListingScreen
import com.university.listing.viewmodel.ListingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var listingViewModel: ListingViewModel? = null

    private val detailsLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == DetailsActivity.RESULT_REFRESH) {
            listingViewModel?.processIntent(ListingIntent.RefreshUniversities)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                val viewModel: ListingViewModel = hiltViewModel()

                listingViewModel = viewModel

                NavHost(
                    navController = navController,
                    startDestination = Screen.Listing.route
                ) {
                    composable(Screen.Listing.route) {
                        ListingScreen(
                            onNavigateToDetails = { university ->
                                launchDetails(university)
                            },
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }

    private fun launchDetails(university: University) {
        val intent = DetailsActivity.createIntent(this, university)
        detailsLauncher.launch(intent)
    }
}
