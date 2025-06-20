package com.example.tp_flashcard

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.tp_flashcard.ui.theme.Blue
import com.example.tp_flashcard.ui.theme.Purple
import com.example.tp_flashcard.ui.theme.Red
import kotlinx.coroutines.launch

@Composable
fun FlashcardScreen ( fvm : FlashcardViewModel, onFinished: () -> Unit) {
    var question by remember { mutableStateOf(fvm.getCurrentCard().question) }
    var answer by remember { mutableStateOf(fvm.getCurrentCard().answer) }
    var answerShow by remember { mutableStateOf(false) }
    var percentage by remember { mutableFloatStateOf(0.0f) }
    var rotateY = remember { Animatable(0f) }
    val offsetX = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .statusBarsPadding()
    ) {
        LinearProgressIndicator(
            progress = { percentage },
            color = Blue,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp)
                .fillMaxWidth()
                .height(16.dp)
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .offset { IntOffset(offsetX.value.toInt(), 0)}
                .graphicsLayer {
                    rotationY = rotateY.value
                    cameraDistance = 8 * density
                    if (rotateY.value > 90f) {
                        //reverse the X axe to be readable
                        scaleX = -1f
                    }
                }
                .background(Purple, shape = RoundedCornerShape(8.dp))
                .border(2.dp, Color.Black, shape = RoundedCornerShape(8.dp))
                .shadow(10.dp, RoundedCornerShape(12.dp), clip = false)
                .align(Alignment.Center)
                .fillMaxSize(0.85f)
                .clickable {
                    answerShow = !answerShow
                    val targetRotation = if (answerShow) 180f else 0f
                    //start rotate animation
                    scope.launch {
                        rotateY.animateTo(
                            targetRotation,
                            animationSpec = tween(durationMillis = 600)
                        )
                    }
                },
        ) {
            Text(
                //show answer or question depending on the rotation
                text = if (rotateY.value <= 90f) question else answer,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue,
                contentColor = Color.White
            ),
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = {
                percentage += fvm.addPercentage
                fvm.nextCard()
                //if end of the practice return to the menu
                if (fvm.isFinish()) {
                    onFinished()
                }
                else {
                    answerShow = false

                    //start slide animation
                    scope.launch {
                        offsetX.animateTo(-1000f, tween(300))

                        //rotate the card to put the question first
                        rotateY.animateTo(
                            0f,
                            animationSpec = tween(durationMillis = 100)
                        )

                        question = fvm.getCurrentCard().question
                        answer = fvm.getCurrentCard().answer
                        offsetX.snapTo(800f)
                        offsetX.animateTo(0f, tween(300))
                    }
                }
            }
        ) {
            Text(
                text = "Next"
            )
        }
    }
}
