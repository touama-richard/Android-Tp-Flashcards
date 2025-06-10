package com.example.tp_flashcard

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.tp_flashcard.model.FlashCard
import com.example.tp_flashcard.model.FlashCardCategory
import com.example.tp_flashcard.model.FlashcardUiState

class FlashcardViewModel: ViewModel() {
    // Reprenez la même approche que dans HomeViewModel pour gérer l’état avec une propriété privée mutable
    // et une propriété publique en lecture seule.
    val cards: SnapshotStateList<FlashCardCategory> = mutableStateListOf()


    // Implémentez une fonction qui charge les cartes correspondant à une catégorie donnée.
    // Cette fonction pourra être appelée au moment de la navigation vers l’écran de révision.
    fun tt() {
        //cards.addAll(cat)
    }

    // Implémentez une fonction pour passer à la carte suivante.

    // Prévoyez la gestion de la fin des révisions, par exemple en mettant à jour un indicateur dans l’état.
}