package com.example.tp_flashcard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp_flashcard.model.FlashCardCategory
import com.example.tp_flashcard.ui.theme.Blue
import com.example.tp_flashcard.ui.theme.Gray
import com.example.tp_flashcard.ui.theme.Green

@Composable
fun AppNavHost ( homeViewModel : HomeViewModel, flashcardViewModel : FlashcardViewModel ) {
    val navController = rememberNavController()
    fun move(): (FlashCardCategory) -> Unit = { flash -> navController.navigate(flash.name)}
    fun menu(): () -> Unit = {  navController.navigate("home")}

    Box (
        Modifier.background(Gray)
            .fillMaxSize()
    ) {
        NavHost ( navController , startDestination = "home") {
            composable ("home") {
                HomeScreen ( homeViewModel = homeViewModel, onCategoryClick = move()  /** ... **/)
            }
            for (cat in homeViewModel.categories) {
                composable(cat.name) {
                    flashcardViewModel.loadCards(cat.id)
                    FlashcardScreen(flashcardViewModel, onFinished = menu())
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    homeViewModel : HomeViewModel,
    onCategoryClick : (FlashCardCategory) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            "FlashCards App",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        for (cat in homeViewModel.categories) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue,         // background color
                    contentColor = Color.White           // text/icon color
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = { onCategoryClick(cat) }
            ) {
                Text(
                    text = cat.name
                )
            }
        }
    }
}