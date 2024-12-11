package com.example.fitnessandhealth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.unit.dp
import com.example.fitnessandhealth.ui.theme.FitnessAndHealthTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAndHealthTheme {
                HealthFitnessApp()
            }
        }
    }
}

@Preview
@Composable
fun HealthFitnessApp() {
    MessageText(message = "\t\t\t\tWelcome!\n\nFITNESS & HEALTH")
    MainMenu()
}

@Composable
fun MessageText(message: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier.height(100.dp)
        )
        Text(
            modifier = Modifier,
            text = message
        )
    }
}

@Composable
fun MainMenu(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column (
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.foodw),
                contentDescription = "food"
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Button(onClick = {/*TODO*/}) {
                Text(stringResource(R.string.food))
            }
        }
        Column (
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.healthyfitnessw),
                contentDescription = "fitness"
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Button(onClick = {/*TODO*/}) {
                Text(stringResource(R.string.fitness))
            }
        }
    }
}