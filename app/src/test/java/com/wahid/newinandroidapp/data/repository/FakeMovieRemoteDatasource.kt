package com.wahid.newinandroidapp.data.repository

import com.wahid.newinandroidapp.data.remote.datasource.RemoteMovieDatasource
import com.wahid.newinandroidapp.data.remote.service.MovieDto
import com.wahid.newinandroidapp.data.remote.service.Result

class FakeMovieRemoteDatasource : RemoteMovieDatasource {
    override suspend fun getMovies(map: Map<String, String>): MovieDto {
        return MovieDto(
            page = 1,
            results = listOf(
                Result(
                    id = 1,
                    title = "Movie 1",
                    overview = "Overview of Movie 1",
                    posterPath = "/poster1.jpg",
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
                Result(
                    id = 2,
                    title = "Movie 2",
                    overview = "Overview of Movie 2",
                    posterPath = "/poster1.jpg",
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
            totalPages = 1,
            totalResults = 2
        )
    }

}