package com.example.testretrofit

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class SentenceService(private val api: SentenceApiClient){
    suspend fun getSentence(): Deferred<Sentence> {
        return withContext(Dispatchers.IO) {
            async {
                val res = api.getSentence()
                res.body() ?: Sentence("获取失败")
            }
        }
    }
}