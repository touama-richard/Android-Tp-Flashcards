package com.example.tp_flashcard.model

data class FlashCard (
    val id: Int,                        // Unique identifier for the card
    val idCategory: Int,                // Identifier for the category this card belongs to
    val question: String,               // Text of the question shown to the user
    val answer: String                  // Text of the answer revealed after flipping the card
)

