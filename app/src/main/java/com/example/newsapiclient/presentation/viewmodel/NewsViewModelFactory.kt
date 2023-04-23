package com.example.newsapiclient.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapiclient.domain.usecases.GetNewsHeadlinesUseCase
import com.example.newsapiclient.domain.usecases.GetSearchedNewsUseCase

class NewsViewModelFactory(
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val application: Application
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(getNewsHeadlinesUseCase,
                             getSearchedNewsUseCase,
                             application) as T
    }
}