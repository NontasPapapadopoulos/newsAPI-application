package com.example.newsapiclient.presentation.di

import android.app.Application
import com.example.newsapiclient.domain.usecases.GetNewsHeadlinesUseCase
import com.example.newsapiclient.domain.usecases.GetSearchedNewsUseCase
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
                                    getSearchedNewsUseCase: GetSearchedNewsUseCase): NewsViewModelFactory {
        return NewsViewModelFactory(getNewsHeadlinesUseCase, getSearchedNewsUseCase, application)
    }
}