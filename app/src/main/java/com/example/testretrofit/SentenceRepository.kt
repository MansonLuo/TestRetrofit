package com.example.testretrofit

interface ISentenceRepository {
    suspend fun getSentence():Sentence

    suspend fun getSentencesOf(number: Int, onCaptureSentence: (Sentence) -> Unit)
}

class SentenceRepository(
    val api: SentenceService
): ISentenceRepository {
    override suspend fun getSentence(): Sentence{
        return api.getSentence().await()
    }

    override suspend fun getSentencesOf(number: Int, onCaptureSentence: (Sentence) -> Unit){
        repeat(number) {
            onCaptureSentence(
                api.getSentence().await()
            )
        }
    }

}