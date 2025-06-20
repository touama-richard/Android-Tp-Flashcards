package com.example.tp_flashcard

import com.example.tp_flashcard.model.FlashCard
import com.example.tp_flashcard.model.FlashCardCategory

object FlashCardRepository {
    val categories : List <FlashCardCategory> = listOf (
        FlashCardCategory(1, "Magic the gathering"),
        FlashCardCategory(2, "te"),
        FlashCardCategory(3, "tes"),
        FlashCardCategory(4, "test"),
    )

    val flashcards : List <FlashCard> = listOf (
        FlashCard(1,
            1,
            "Qu’est-ce qu’un sort dans Magic: The Gathering ?",
            "Un sort est toute carte qu’un joueur lance depuis sa main (créature, éphémère, rituel, artefact, enchantement, planeswalker). Les terrains ne sont pas des sorts."),
        FlashCard(2,
            1,
            "Comment produit-on du mana ?",
            "On produit du mana en engageant (tapant) des terrains comme les forêts, îles, marais, montagnes ou plaines. Certains artefacts ou capacités peuvent aussi produire du mana."),
        FlashCard(3,
            1,
            "Que signifie “engager” une carte ?",
            "Engager une carte signifie la tourner de 90 degrés pour montrer qu’elle a été utilisée (souvent pour attaquer ou produire du mana)."),
        FlashCard(4,
            1,
            "Quand peut-on jouer un éphémère ?",
            "À presque n’importe quel moment, y compris pendant le tour de l’adversaire, tant qu’on a la priorité et le mana nécessaire."),
        FlashCard(5,
            1,
            "Quelle est la différence entre une capacité déclenchée et une capacité activée ?",
            "Une capacité déclenchée commence par \"Quand\", \"À chaque fois que\", ou \"Si\" et se déclenche automatiquement. Une capacité activée utilise un coût suivi de \":\" et peut être activée à volonté si le coût est payé."),
        FlashCard(6,
            1,
            "Combien de phases a un tour dans Magic ?",
            "Un tour comprend 5 phases :\n" +
                    "Début du tour (entretien + pioche)\n" +
                    "Phase principale\n" +
                    "Phase de combat\n" +
                    "Seconde phase principale\n" +
                    "Fin du tour\n"),
        FlashCard(7,
            1,
            "Que se passe-t-il si deux créatures s'infligent des blessures mortelles en combat ?",
            "Les deux créatures meurent en même temps, à moins qu’une capacité ne les empêche de mourir (comme l’indestructible ou la protection)."),
        FlashCard(8,
            1,
            "Peut-on bloquer une créature avec plusieurs créatures ?",
            "Oui. Le joueur défenseur peut assigner plusieurs bloqueurs à une seule créature attaquante. L’attaquant choisit ensuite l’ordre dans lequel les bloqueurs subiront les blessures."),
        FlashCard(9,
            1,
            "Qu’est-ce que la pile (“stack”) ?",
            "La pile est un système de résolution des sorts et capacités : le dernier sort joué est le premier à être résolu (LIFO – Last In, First Out)."),
        FlashCard(10,
            1,
            "Peut-on jouer plusieurs terrains par tour ?",
            "Non. Un joueur peut poser un seul terrain par tour, sauf effet contraire d’une carte (ex : \"Exploration\")."),
        FlashCard(11,
            2,"question t2","r t2"),
        FlashCard(12,
            3,"question t3","r t3"),
        FlashCard(13,
            4,"question t4","r t4"),
        FlashCard(14,
            4,"question t4","r t4"),
    )
}