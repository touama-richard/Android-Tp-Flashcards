package com.example.tp_flashcard.model

data class FlashcardUiState(
    val indexCard: Int = -1,                                    //L’index de la carte actuellement affichée.
    val cardsPractice: List<FlashCard> = mutableListOf(),       // La liste des cartes à réviser.
    val finished: Boolean = indexCard >= cardsPractice.count()  // Un indicateur booléen indiquant si la session de révision est terminée.
)
