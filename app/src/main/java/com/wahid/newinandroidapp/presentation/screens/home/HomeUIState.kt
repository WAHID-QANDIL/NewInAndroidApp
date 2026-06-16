package com.wahid.newinandroidapp.presentation.screens.home

import com.wahid.newinandroidapp.domain.model.Movie

data class HomeUIState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String? = null
)
