package com.example.testretrofit

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SentenceViewModel(
    private val repository: SentenceRepository
): ViewModel() {
    val sentence = mutableStateOf<String?>(null)
    val multipleSentences = mutableStateListOf<Sentence?>(null)

    fun loadNextSentence() {
        viewModelScope.launch {
            sentence.value = repository.getSentence().anwei
        }
    }

    fun loadSentenceOf(number: Int) {
        multipleSentences.clear()

        viewModelScope.launch {
            repository.getSentencesOf(number) {
                multipleSentences.add(it)
            }
        }
    }
}