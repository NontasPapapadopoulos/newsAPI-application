package com.example.newsapiclient.domain.usecases

import com.example.newsapiclient.domain.repository.NewsRepository
import com.example.newsapiclient.data.model.APIResponse
import com.example.newsapiclient.data.util.Resource

class GetSearchedNewsUseCase (private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, searchQuery: String, pages: Int): Resource<APIResponse> {
        return newsRepository.getSearchedNews(country, searchQuery, pages)
    }
}