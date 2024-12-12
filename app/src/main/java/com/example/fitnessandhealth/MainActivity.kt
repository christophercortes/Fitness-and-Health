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
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.height
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.focusModifier
import kotlin.math.pow
import com.example.fitnessandhealth.ui.theme.FitnessAndHealthTheme
import java.text.NumberFormat
import java.text.DecimalFormat


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
    //NumberField()
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
            text = message,
            fontSize = 18.sp
        )
    }
}

@Composable
fun MainMenu(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(16.dp).fillMaxSize(),
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

@Composable
private fun calculateBMI(pounds: Double, inches: Double): String {
    val bodyMassIndex = pounds * 703 / inches.pow(2.0)
    val decimalFormat = DecimalFormat("#.##")
    return decimalFormat.format(bodyMassIndex)
}

@Composable
fun NumberField() {
    var poundsInput by remember {mutableStateOf("")}
    var inchesInput by remember {mutableStateOf("")}

    val pounds = poundsInput.toDoubleOrNull() ?: 0.0
    val inches = inchesInput.toDoubleOrNull() ?: 0.0

    val bodyMassIndex = calculateBMI(pounds, inches)

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.calculate_bmi),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        TextField(
            label = {Text(stringResource(R.string.pounds))},
            value = poundsInput,
            onValueChange = {poundsInput = it},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        TextField(
            label = { Text(stringResource(R.string.inches)) },
            value = inchesInput,
            onValueChange = {inchesInput = it},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = stringResource(R.string.body_mass_index, bodyMassIndex))
    }
}

@Composable
fun FoodRecommendation() {

}

@Composable
fun FitnessRecommendation() {

}