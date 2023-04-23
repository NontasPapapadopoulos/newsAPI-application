package com.example.newsapiclient.domain.usecases

import com.example.newsapiclient.domain.repository.NewsRepository
import com.example.newsapiclient.data.model.Article

class DeleteSavedNewsUseCase (private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}