package com.example.newsapiclient.presentation.di

import androidx.core.os.BuildCompat
import com.example.newsapiclient.data.api.NewsAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://newsapi.org")
            .build()
    }


    @Singleton
    @Provides
    fun provideNewsApiService(retrofit: Retrofit):NewsAPIService {
        return retrofit.create(NewsAPIService::class.java)
    }

// giati oxi auto ?
    
//    @Singleton
//    @Provides
//    fun provideRetrofitInstance(): NewsAPIService {
//        return Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl("https://newsapi.org")
//            .build().create(NewsAPIService::class.java)
//    }

}