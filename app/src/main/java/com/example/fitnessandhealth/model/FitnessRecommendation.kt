package com.example.fitnessandhealth.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class FitnessRecommendation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
