package com.example.tp_flashcard.model

data class FlashcardUiState(
    var indexCard: Int = -1,                                    //L’index de la carte actuellement affichée.
    var cardsPractice: List<FlashCard> = mutableListOf(),       // La liste des cartes à réviser.
    var finished: Boolean = false                               // Un indicateur booléen indiquant si la session de révision est terminée.
)
