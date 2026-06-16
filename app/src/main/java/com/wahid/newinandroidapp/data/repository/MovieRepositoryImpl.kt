package com.wahid.newinandroidapp.data.repository

import com.wahid.newinandroidapp.data.remote.datasource.RemoteMovieDatasource
import com.wahid.newinandroidapp.data.remote.service.toDomainModel
import com.wahid.newinandroidapp.di.IO
import com.wahid.newinandroidapp.domain.model.Movie
import com.wahid.newinandroidapp.domain.repository.MovieRepository
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlin.collections.emptyList

class MovieRepositoryImpl @Inject constructor(
    private val remoteMovieDatasource: RemoteMovieDatasource,
    val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
) : MovieRepository {
    override suspend fun getMovies(map: Map<String, String>): List<Movie> {
        try {
            return coroutineScope.async {
                remoteMovieDatasource.getMovies(map).results?.map { movieDto ->
                    movieDto!!.toDomainModel().also {
                        it.posterPath = "https://image.tmdb.org/t/p/w500${movieDto.posterPath}"
                    }
                } ?: emptyList()
            }.await()

        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }

    }
}