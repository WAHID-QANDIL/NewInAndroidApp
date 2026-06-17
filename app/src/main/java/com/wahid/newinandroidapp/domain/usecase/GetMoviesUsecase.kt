package com.wahid.newinandroidapp.domain.usecase

import com.wahid.newinandroidapp.domain.model.Movie
import com.wahid.newinandroidapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.random.Random

class GetMoviesUseCase @Inject constructor(
    val movieRepository: MovieRepository
) {

    operator fun invoke(query: Map<String, String>): Flow<List<Movie>> {
        val defaultQuery = mapOf(
            "include_adult" to "false",
            "include_video" to "true",
            "language" to "en-US",
            "page" to Random.nextInt(1, 100).toString()
        )
        return movieRepository.getMovies(query.let { query + defaultQuery })
    }

}