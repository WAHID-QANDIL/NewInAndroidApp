package com.wahid.newinandroidapp.domain.model

data class Movie(
    val id: Int,
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int?>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    var posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)