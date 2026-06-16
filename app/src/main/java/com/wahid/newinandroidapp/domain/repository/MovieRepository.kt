package com.wahid.newinandroidapp.domain.repository

import com.wahid.newinandroidapp.domain.model.Movie

interface MovieRepository {
    suspend fun getMovies(map: Map<String, String>): List<Movie>
}