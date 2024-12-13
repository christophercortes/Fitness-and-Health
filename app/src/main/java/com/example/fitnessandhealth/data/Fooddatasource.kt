package com.example.fitnessandhealth.data

import com.example.fitnessandhealth.R
import com.example.fitnessandhealth.model.FoodRecommendation

class Fooddatasource {
    fun loadFoodRecommendations(): List<FoodRecommendation> {
        return listOf<FoodRecommendation>(
            FoodRecommendation(R.string.food_recommendation1, R.drawable.oatmeal),
            FoodRecommendation(R.string.food_recommendation2, R.drawable.sandwich),
            FoodRecommendation(R.string.food_recommendation3, R.drawable.brownrice),
            FoodRecommendation(R.string.food_recommendation4, R.drawable.englishmuffin),
            FoodRecommendation(R.string.food_recommendation5, R.drawable.popcorn),
            FoodRecommendation(R.string.food_recommendation6, R.drawable.wholegrainpasta),
            FoodRecommendation(R.string.food_recommendation7, R.drawable.wholegraincereal),
            FoodRecommendation(R.string.food_recommendation8, R.drawable.wholewheatpita),
            FoodRecommendation(R.string.food_recommendation9, R.drawable.quinoa),
        )
    }
}