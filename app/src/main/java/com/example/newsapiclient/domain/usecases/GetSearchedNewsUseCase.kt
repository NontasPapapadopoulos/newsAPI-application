package com.example.newsapiclient.domain.usecases

import com.example.newsapiclient.domain.repository.NewsRepository
import com.example.newsapiclient.data.model.APIResponse
import com.example.newsapiclient.data.util.Resource

class GetSearchedNewsUseCase (private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }
}