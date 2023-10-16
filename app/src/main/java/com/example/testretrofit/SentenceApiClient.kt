package com.example.testretrofit

import okhttp3.Response
import retrofit2.http.GET

interface SentenceApiClient {
    @GET("api/api-wenan-anwei/index.php?type=json")
    suspend fun getSentence(): retrofit2.Response<Sentence>
}