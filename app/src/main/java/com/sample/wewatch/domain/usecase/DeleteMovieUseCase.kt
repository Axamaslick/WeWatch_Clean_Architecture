package com.sample.wewatch.domain.usecase

import com.sample.wewatch.domain.model.Movie
import com.sample.wewatch.domain.repository.MovieRepository

class DeleteMovieUseCase(private val repository: MovieRepository) {
    operator fun invoke(movie: Movie) = repository.deleteMovie(movie)
}