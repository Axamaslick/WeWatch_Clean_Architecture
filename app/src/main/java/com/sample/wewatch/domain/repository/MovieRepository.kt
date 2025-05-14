package com.sample.wewatch.domain.repository

import io.reactivex.Observable
import com.sample.wewatch.domain.model.Movie

interface MovieRepository {
    fun getAllMovies(): Observable<List<Movie>>
    fun addMovie(movie: Movie)
    fun deleteMovie(movie: Movie)
    fun updateMovie(movie: Movie)
}