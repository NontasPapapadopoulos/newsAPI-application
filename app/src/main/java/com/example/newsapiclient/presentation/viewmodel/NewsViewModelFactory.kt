package com.example.newsapiclient.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapiclient.domain.usecases.DeleteSavedNewsUseCase
import com.example.newsapiclient.domain.usecases.GetNewsHeadlinesUseCase
import com.example.newsapiclient.domain.usecases.GetSavedNewsUseCase
import com.example.newsapiclient.domain.usecases.GetSearchedNewsUseCase
import com.example.newsapiclient.domain.usecases.SaveNewsUseCase

class NewsViewModelFactory(
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsUseCase: GetSavedNewsUseCase,
    private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase,
    private val application: Application
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(getNewsHeadlinesUseCase,
                             getSearchedNewsUseCase,
                             saveNewsUseCase,
                             getSavedNewsUseCase,
                             deleteSavedNewsUseCase,
                             application) as T
    }
}