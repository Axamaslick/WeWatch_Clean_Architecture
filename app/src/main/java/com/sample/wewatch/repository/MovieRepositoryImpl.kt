package com.sample.wewatch.repository

import com.sample.wewatch.local.LocalDataSource
import com.sample.wewatch.domain.model.Movie
import com.sample.wewatch.domain.repository.MovieRepository
import io.reactivex.Observable

class MovieRepositoryImpl(private val localDataSource: LocalDataSource) : MovieRepository {
    override fun getAllMovies(): Observable<List<Movie>> = localDataSource.allMovies
    override fun addMovie(movie: Movie) = localDataSource.insert(movie)
    override fun deleteMovie(movie: Movie) = localDataSource.delete(movie)
    override fun updateMovie(movie: Movie) = localDataSource.update(movie)
}