package com.university.details.ui

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.university.core.domain.model.University
import com.university.details.databinding.ActivityDetailsBinding
import com.university.details.intent.DetailsIntent
import com.university.details.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "University Details"
        }

        val university = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_UNIVERSITY, University::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_UNIVERSITY)
        }

        university?.let { viewModel.setUniversity(it) }

        setupListeners()
        observeState()
    }

    private fun setupListeners() {
        binding.btnRefresh.setOnClickListener {
            viewModel.processIntent(DetailsIntent.Refresh)
        }
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    state.university?.let { renderUniversity(it) }

                    if (state.navigateBackWithRefresh) {
                        viewModel.onNavigationHandled()
                        setResult(RESULT_REFRESH)
                        finish()
                    }
                }
            }
        }
    }

    private fun renderUniversity(university: University) {
        with(binding) {
            tvName.text = university.name
            tvCountry.text = university.country
            tvCode.text = university.alphaTwoCode

            if (!university.stateProvince.isNullOrBlank()) {
                tvStateLabel.visibility = View.VISIBLE
                tvState.visibility = View.VISIBLE
                tvState.text = university.stateProvince
            } else {
                tvStateLabel.visibility = View.GONE
                tvState.visibility = View.GONE
            }

            tvDomains.text = university.domains.joinToString("\n")
            tvWebPages.text = university.webPages.joinToString("\n")
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_UNIVERSITY = "extra_university"
        const val RESULT_REFRESH = 100

        fun createIntent(context: Context, university: University): Intent {
            return Intent(context, DetailsActivity::class.java).apply {
                putExtra(EXTRA_UNIVERSITY, university)
            }
        }
    }
}
