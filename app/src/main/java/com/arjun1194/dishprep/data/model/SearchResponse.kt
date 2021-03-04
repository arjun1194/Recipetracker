package com.arjun1194.dishprep.data.model

data class SearchResponse(
    val offset: Int,
    val number: Int,
    val results: List<Recipe>
)


