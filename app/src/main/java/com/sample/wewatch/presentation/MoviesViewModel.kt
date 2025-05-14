package com.sample.wewatch.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.wewatch.domain.model.Movie
import com.sample.wewatch.domain.usecase.AddMovieUseCase
import com.sample.wewatch.domain.usecase.DeleteMovieUseCase
import com.sample.wewatch.domain.usecase.GetAllMoviesUseCase
import io.reactivex.disposables.CompositeDisposable

class MoviesViewModel(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    private val disposable = CompositeDisposable()

    fun loadMovies() {
        disposable.add(
            getAllMoviesUseCase()
                .subscribe(
                    { moviesList -> _movies.postValue(moviesList) },
                    { error -> /* обработка ошибки, например лог */ }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}