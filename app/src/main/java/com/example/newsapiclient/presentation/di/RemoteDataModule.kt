package com.example.newsapiclient.presentation.di

import com.example.newsapiclient.data.api.NewsAPIService
import com.example.newsapiclient.data.model.repository.dataSource.NewsRemoteDataSource
import com.example.newsapiclient.data.model.repository.dataSourceImp.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {


    @Singleton
    @Provides
    fun provideNewsRemodeDataSource(newsAPIService: NewsAPIService): NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(newsAPIService)
    }


}