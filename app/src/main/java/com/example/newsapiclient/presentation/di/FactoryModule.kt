package com.example.newsapiclient.presentation.di

import android.app.Application
import com.example.newsapiclient.domain.usecases.DeleteSavedNewsUseCase
import com.example.newsapiclient.domain.usecases.GetNewsHeadlinesUseCase
import com.example.newsapiclient.domain.usecases.GetSavedNewsUseCase
import com.example.newsapiclient.domain.usecases.GetSearchedNewsUseCase
import com.example.newsapiclient.domain.usecases.SaveNewsUseCase
import com.example.newsapiclient.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {


    @Provides
    @Singleton
    fun provideNewsViewModelFactory(application: Application,
                                    getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
                                    getSearchedNewsUseCase: GetSearchedNewsUseCase,
                                    saveNewsUseCase: SaveNewsUseCase,
                                    getSavedNewsUseCase: GetSavedNewsUseCase,
                                    deleteSavedNewsUseCase: DeleteSavedNewsUseCase)
    : NewsViewModelFactory {


        return NewsViewModelFactory(getNewsHeadlinesUseCase,
                                    getSearchedNewsUseCase,
                                    saveNewsUseCase,
                                    getSavedNewsUseCase,
                                    deleteSavedNewsUseCase,
                                    application)
    }
}