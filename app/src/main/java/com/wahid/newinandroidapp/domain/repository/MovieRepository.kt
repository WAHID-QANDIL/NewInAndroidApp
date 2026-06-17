package com.wahid.newinandroidapp.domain.repository

import com.wahid.newinandroidapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovies(map: Map<String, String>): Flow<List<Movie>>
}