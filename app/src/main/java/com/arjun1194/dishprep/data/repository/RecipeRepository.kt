package com.arjun1194.dishprep.data.repository

import com.arjun1194.dishprep.api.RecipeService
import com.arjun1194.dishprep.data.model.DataResponse
import com.arjun1194.dishprep.data.model.SearchResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val recipeService: RecipeService
){
        fun getSearchResponse(query: String,cuisine:String,diet:String): Flow<DataResponse<SearchResponse>> {
            return flow<DataResponse<SearchResponse>> {
                try {
                    val networkResponse = recipeService.searchRecipe(query,cuisine,diet)
                    emit(DataResponse.Success(networkResponse))
                } catch (e: Exception) {
                    emit(DataResponse.Error(e))
                }

            }
        }
}