package com.wahid.newinandroidapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wahid.newinandroidapp.domain.usecase.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okio.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
): ViewModel() {

    val uiState: StateFlow<HomeUIState>
        field = MutableStateFlow(HomeUIState())

    init {
        viewModelScope.launch {
            uiState.update {
                it.copy(
                    isLoading = true,
                    movies = emptyList(),
                    error = null
                )
            }
            try {
                getMoviesUseCase(mapOf(
                    "adult" to "false"
                )).also { moviesListFlow ->
                    moviesListFlow.collect { movies ->
                        uiState.update {
                            it.copy(
                                isLoading = false,
                                movies = movies,
                                error = null
                            )
                        }
                    }
                }

            } catch (e: IOException) {
                uiState.update {
                    it.copy(
                        isLoading = false,
                        movies = emptyList(),
                        error = e.message
                    )
                }
            }
        }
    }
}

/*
class HomeViewModelFactory @Inject constructor(
    val getMoviesUseCase: GetMoviesUseCase
): ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
             HomeViewModel(getMoviesUseCase) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}*/
