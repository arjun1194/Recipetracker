package com.arjun1194.dishprep.data.model

data class Recipe(
    val id: Int,
    val calories: Int,
    val carbs: String,
    val fat: String,
    val image: String,
    val imageType: String,
    val protein: String,
    val title: String
)