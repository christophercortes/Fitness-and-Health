package com.example.fitnessandhealth.data

import com.example.fitnessandhealth.R
import com.example.fitnessandhealth.model.FitnessRecommendation

class Fitnessdatasource {
    fun loadFitnessRecommendations():List<FitnessRecommendation> {
        return listOf<FitnessRecommendation>(
            FitnessRecommendation(R.string.fitness_recommendation1, R.drawable.briskwalking),
            FitnessRecommendation(R.string.fitness_recommendation2, R.drawable.running),
            FitnessRecommendation(R.string.fitness_recommendation3, R.drawable.aerobic),
            FitnessRecommendation(R.string.fitness_recommendation4, R.drawable.legs),
            FitnessRecommendation(R.string.fitness_recommendation5, R.drawable.arms),
            FitnessRecommendation(R.string.fitness_recommendation6, R.drawable.abdomen),
        )
    }
}