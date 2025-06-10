package com.example.tp_flashcard

import android.service.autofill.OnClickAction
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp_flashcard.model.FlashCardCategory

@Composable
fun AppNavHost ( homeViewModel : HomeViewModel ) {
    val navController = rememberNavController()

    fun move(): (FlashCardCategory) -> Unit = { flash -> navController.navigate(flash.name)}

    NavHost ( navController , startDestination = " home ") {
        composable (" home ") {
            HomeScreen ( homeViewModel = homeViewModel, onCategoryClick = move()  /** ... **/)
        }
        //changer nom en id
        composable("card") {
            Text("Card")
        }
        composable("te") {
            Text("te")
        }
        composable("tes") {
            Text("tes")
        }
        composable("test") {
            Text("test")
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
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (cat in homeViewModel.categories) {
            Button(
                modifier = Modifier,
                onClick = { onCategoryClick(cat) }
            ) {
                Text(
                    text = cat.name
                )
            }
        }
    }
}

@Composable
fun FlashcardScreen(homeViewModel : HomeViewModel) {

}