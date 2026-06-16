package com.wahid.newinandroidapp.domain.usecase

import com.wahid.newinandroidapp.domain.model.Movie
import com.wahid.newinandroidapp.domain.repository.MovieRepository
import javax.inject.Inject
import kotlin.random.Random

class GetMoviesUseCase @Inject constructor(
    val movieRepository: MovieRepository
) {

    suspend operator fun invoke(query: Map<String, String>): List<Movie> {
        val defaultQuery = mapOf(
            "include_adult" to "false",
            "include_video" to "false",
            "language" to "en-US",
            "page" to Random.nextInt(1, 100).toString()
        )
        return movieRepository.getMovies(query.let { query + defaultQuery })
    }

}