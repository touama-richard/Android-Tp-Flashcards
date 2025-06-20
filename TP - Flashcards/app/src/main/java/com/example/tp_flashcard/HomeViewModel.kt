package com.example.tp_flashcard

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.tp_flashcard.model.FlashCard
import com.example.tp_flashcard.model.FlashCardCategory
import com.example.tp_flashcard.model.FlashcardUiState

class HomeViewModel: ViewModel() {

    val categories : SnapshotStateList<FlashCardCategory> = mutableStateListOf();
    val flashcards : SnapshotStateList<FlashCard> = mutableStateListOf();
    val flashcarduistate : FlashcardUiState

    init {
        categories.addAll(FlashCardRepository.categories)
        flashcards.addAll(FlashCardRepository.flashcards)
        flashcarduistate = FlashcardUiState(0,flashcards)
    }

}