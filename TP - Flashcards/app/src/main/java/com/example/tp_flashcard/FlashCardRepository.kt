package com.example.tp_flashcard

import com.example.tp_flashcard.model.FlashCard
import com.example.tp_flashcard.model.FlashCardCategory

object FlashCardRepository {
    // Singleton providing flashcard data

    // List of categories available in the app
    val categories : List <FlashCardCategory> = listOf (
        FlashCardCategory(1, "card"),
        FlashCardCategory(2, "te"),
        FlashCardCategory(3, "tes"),
        FlashCardCategory(4, "test"),
    )
    // List of flashcards with references to categories
    val flashcards : List <FlashCard> = listOf (
    // ...
    )
}