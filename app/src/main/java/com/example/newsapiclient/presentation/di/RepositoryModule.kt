package com.example.newsapiclient.presentation.di

import com.example.newsapiclient.data.model.repository.dataSource.NewsLocalDataSource
import com.example.newsapiclient.data.model.repository.dataSource.NewsRemoteDataSource
import com.example.newsapiclient.domain.repository.NewsRepository
import com.example.newsapiclient.domain.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {


    @Provides
    @Singleton
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource,
                             newsLocalDataSource: NewsLocalDataSource): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource)
    }

}