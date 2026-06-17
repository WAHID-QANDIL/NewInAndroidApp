package com.wahid.newinandroidapp.data.repository

import com.wahid.newinandroidapp.data.remote.datasource.RemoteMovieDatasource
import com.wahid.newinandroidapp.data.remote.service.toDomainModel
import com.wahid.newinandroidapp.domain.model.Movie
import com.wahid.newinandroidapp.domain.repository.MovieRepository
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl @Inject constructor(
    private val remoteMovieDatasource: RemoteMovieDatasource,
    val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
) : MovieRepository {

    override fun getMovies(map: Map<String, String>): Flow<List<Movie>> = flow {
        remoteMovieDatasource
            .getMovies(map = map)
            .results?.mapNotNull { result ->
                result?.toDomainModel().also { movie->
                    movie?.posterPath = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
                }
            }
            ?.let { movies ->
                emit(movies)
            }
    }
}