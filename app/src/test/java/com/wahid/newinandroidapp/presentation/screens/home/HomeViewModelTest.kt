package com.wahid.newinandroidapp.presentation.screens.home

import com.wahid.newinandroidapp.data.remote.datasource.RemoteMovieDatasourceImpl
import com.wahid.newinandroidapp.data.repository.FakeMovieRemoteDatasource
import com.wahid.newinandroidapp.data.repository.MovieRepositoryImpl
import com.wahid.newinandroidapp.domain.model.Movie
import com.wahid.newinandroidapp.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {

    lateinit var viewModel: HomeViewModel
    @Before
    fun setUp() {
        viewModel = HomeViewModel(
            getMoviesUseCase = GetMoviesUseCase(
                movieRepository = MovieRepositoryImpl(
                    remoteMovieDatasource = FakeMovieRemoteDatasource()
                )
            )
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when getMovies is called, then movies state should be updated`() = runTest {
        viewModel.uiState.collect()
        runCurrent()
        assertThat(viewModel.uiState.value, `is`(HomeUIState(
            isLoading = false,
            movies = listOf(
                Movie(
                    id = 1,
                    title = "Movie 1",
                    overview = "Overview of Movie 1",
                    posterPath = "https://image.tmdb.org/t/p/w500/poster1.jpg",
                    releaseDate = "2023-01-01",
                    adult = false,
                    video = false,
                    originalLanguage = "en",
                    originalTitle = "Movie 1",
                    popularity = 20.0,
                    voteAverage = 8.0,
                    voteCount = 200,
                    genreIds = listOf(1, 2, 3),
                    backdropPath = "https://image.tmdb.org/t/p/w500/poster1.jpg"
                ),
                Movie(
                    id = 2,
                    title = "Movie 2",
                    overview = "Overview of Movie 2",
                    posterPath = "https://image.tmdb.org/t/p/w500/poster1.jpg",
                    releaseDate = "2023-02-01",
                    adult = false,
                    video = false,
                    originalLanguage = "en",
                    originalTitle = "Movie 2",
                    popularity = 10.0,
                    voteAverage = 7.5,
                    voteCount = 100,
                    genreIds = listOf(1, 2, 3),
                    backdropPath = "https://image.tmdb.org/t/p/w500/poster1.jpg"
                )
            ),
            error = null
        )))

    }
}
