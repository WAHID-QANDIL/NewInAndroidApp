package com.wahid.newinandroidapp.data.remote.datasource

import com.wahid.newinandroidapp.data.remote.service.MovieDto

interface RemoteMovieDatasource {
    suspend fun getMovies(map: Map<String, String>): MovieDto
}