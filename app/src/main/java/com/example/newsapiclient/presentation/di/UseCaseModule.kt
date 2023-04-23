package com.example.newsapiclient.presentation.di

import com.example.newsapiclient.domain.repository.NewsRepository
import com.example.newsapiclient.domain.usecases.GetNewsHeadlinesUseCase
import com.example.newsapiclient.domain.usecases.GetSearchedNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {


    @Provides
    @Singleton
    fun providesGetNewsHeadLinesUseCase(newsRepository: NewsRepository): GetNewsHeadlinesUseCase {
        return GetNewsHeadlinesUseCase(newsRepository)
    }

    @Provides
    @Singleton
    fun providesGetSearchedNewsUseCase(newsRepository: NewsRepository): GetSearchedNewsUseCase {
        return GetSearchedNewsUseCase(newsRepository)
    }

}