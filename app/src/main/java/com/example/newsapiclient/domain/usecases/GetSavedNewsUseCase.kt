package com.example.newsapiclient.domain.usecases

import androidx.lifecycle.LiveData
import com.example.newsapiclient.domain.repository.NewsRepository
import com.example.newsapiclient.data.model.Article
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase (private val newsRepository: NewsRepository) {

    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }

}