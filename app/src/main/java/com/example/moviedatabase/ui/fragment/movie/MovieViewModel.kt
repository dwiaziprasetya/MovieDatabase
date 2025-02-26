package com.example.moviedatabase.ui.fragment.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.moviedatabase.data.remote.response.DiscoverMovieItem
import com.example.moviedatabase.repository.MovieDatabaseRepository

class MovieViewModel(
    private val repository: MovieDatabaseRepository
): ViewModel() {
    val movie: LiveData<PagingData<DiscoverMovieItem>> =
        repository.getDiscoverMovieDataPaging().cachedIn(viewModelScope)
}