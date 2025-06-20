package com.example.tp_flashcard

import androidx.lifecycle.ViewModel
import com.example.tp_flashcard.model.FlashCard
import com.example.tp_flashcard.model.FlashcardUiState

class FlashcardViewModel: ViewModel() {
    val cards: List<FlashCard> = FlashCardRepository.flashcards
    val practice: FlashcardUiState = FlashcardUiState()
    var addPercentage: Float = 0.1f

    fun loadCards(idCategory: Int) {
        practice.cardsPractice = cards.filter { it.idCategory == idCategory}
        practice.indexCard = 0
        addPercentage = 1.0f / practice.cardsPractice.size
    }

    fun isFinish(): Boolean{
        return practice.finished
    }

    fun getCurrentCard(): FlashCard {
        return practice.cardsPractice[practice.indexCard]
    }

    fun nextCard() {
        practice.indexCard++
        practice.finished = practice.indexCard >= practice.cardsPractice.size
    }
}