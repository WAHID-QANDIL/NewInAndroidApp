package com.wahid.newinandroidapp.data.remote.datasource

import com.wahid.newinandroidapp.data.remote.service.MovieDto
import com.wahid.newinandroidapp.data.remote.service.MovieService
import jakarta.inject.Inject

class RemoteMovieDatasourceImpl @Inject constructor(
    private val movieService: MovieService
) : RemoteMovieDatasource {
    override suspend fun getMovies(map: Map<String, String>): MovieDto {
        return movieService.getMovies(map)
    }
}