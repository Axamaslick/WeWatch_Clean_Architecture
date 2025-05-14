package com.sample.wewatch.domain.usecase

import io.reactivex.Observable
import com.sample.wewatch.domain.model.Movie
import com.sample.wewatch.domain.repository.MovieRepository

class GetAllMoviesUseCase(private val repository: MovieRepository) {
    operator fun invoke(): Observable<List<Movie>> = repository.getAllMovies()
}