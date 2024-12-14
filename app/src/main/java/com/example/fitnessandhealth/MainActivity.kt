package com.example.fitnessandhealth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessandhealth.data.Fitnessdatasource
import com.example.fitnessandhealth.data.Fooddatasource
import com.example.fitnessandhealth.model.FitnessRecommendation
import com.example.fitnessandhealth.model.FoodRecommendation
import com.example.fitnessandhealth.ui.theme.FitnessAndHealthTheme
import java.text.DecimalFormat
import kotlin.math.pow


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

//Main composable function called
@Preview
@Composable
fun HealthFitnessApp() {
    MainMenu()
}

//Welcome message composable function
@Composable
fun MessageText(message: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Text(
            modifier = Modifier,
            text = message,
            fontSize = 18.sp
        )
    }
}

//Main composable function
@Composable
fun MainMenu(modifier: Modifier = Modifier) {
    //MessageText(message = "\t\t\t\tWelcome!\n\nFITNESS & HEALTH")
    NumberField()

    var showFoodList by remember { mutableStateOf(false) }
    var showFitnessList by remember { mutableStateOf(false) }

    when {
        showFoodList -> {
            FoodList(foodList = Fooddatasource().loadFoodRecommendations())
        }

        showFitnessList -> {
            FitnessList(fitnessList = Fitnessdatasource().loadFitnessRecommendations())

        }

        else -> {
            Row(
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
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
                    Button(onClick = { showFoodList = true }) {
                        Text(stringResource(R.string.food))
                    }
                }
                Column(
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
                    Button(onClick = { showFitnessList = true }) {
                        Text(stringResource(R.string.fitness))
                    }
                }
            }
        }
    }
}

//composable function that implements math operation to calculate BMI
@Composable
private fun calculateBMI(pounds: Double, inches: Double): String {
    val bodyMassIndex = pounds * 703 / inches.pow(2.0)
    val decimalFormat = DecimalFormat("#.##")
    return decimalFormat.format(bodyMassIndex)
}

//NumberField composable function that provides the Card function to display the BMI
@Composable
fun NumberField() {
    var poundsInput by remember { mutableStateOf("") }
    var inchesInput by remember { mutableStateOf("") }

    val pounds = poundsInput.toDoubleOrNull() ?: 0.0
    val inches = inchesInput.toDoubleOrNull() ?: 0.0
    val bodyMassIndex = calculateBMI(pounds, inches)

    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.calculate_bmi),
                modifier = Modifier
                    .padding(bottom = 8.dp),
                fontSize = 18.sp,
                style = MaterialTheme.typography.headlineSmall
            )
            TextField(
                label = { Text(stringResource(R.string.pounds)) },
                value = poundsInput,
                onValueChange = { poundsInput = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            TextField(
                label = { Text(stringResource(R.string.inches)) },
                value = inchesInput,
                onValueChange = { inchesInput = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            Text(
                text = stringResource(R.string.body_mass_index, bodyMassIndex),
                modifier = Modifier.padding(top = 8.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun NumberFieldPreview() {
    NumberField()
}

//Food list composable function
@Composable
fun FoodList(foodList: List<FoodRecommendation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(foodList) { food ->
            FoodRecommendationCard(
                foodRecommendation = food,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

//Fitness list composable function
@Composable
fun FitnessList(fitnessList: List<FitnessRecommendation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(fitnessList) { fitness ->
            FitnessRecommendationCard(
                fitnessRecommendation = fitness,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

//Food card composable function
@Composable
fun FoodRecommendationCard(foodRecommendation: FoodRecommendation, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(foodRecommendation.imageResourceId),
                contentDescription = stringResource(foodRecommendation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(foodRecommendation.stringResourceId),
                modifier = Modifier
                    .padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

//Fitness card composable function
@Composable
fun FitnessRecommendationCard(
    fitnessRecommendation: FitnessRecommendation,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(fitnessRecommendation.imageResourceId),
                contentDescription = stringResource(fitnessRecommendation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(fitnessRecommendation.stringResourceId),
                modifier = Modifier
                    .padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }

    }

}

@Preview
@Composable
private fun FoodCard() {
    FoodRecommendationCard(FoodRecommendation(R.string.food_recommendation1, R.drawable.oatmeal))
}

@Preview
@Composable
private fun FitnessCard() {
    FitnessRecommendationCard(
        FitnessRecommendation(
            R.string.fitness_recommendation1,
            R.drawable.running
        )
    )
}