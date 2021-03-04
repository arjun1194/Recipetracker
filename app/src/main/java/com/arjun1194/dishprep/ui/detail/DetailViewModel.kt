package com.arjun1194.dishprep.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arjun1194.dishprep.data.model.DataResponse
import com.arjun1194.dishprep.data.model.SearchResponse
import com.arjun1194.dishprep.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {
    private val _searchResponse = MutableLiveData<DataResponse<SearchResponse>>();

    val searchResponse = _searchResponse as LiveData<DataResponse<SearchResponse>>;

    fun getSearchResults(query: String,cuisine:String,diet:String) {
        viewModelScope.launch {
            recipeRepository.getSearchResponse(query,cuisine,diet).onEach {
                _searchResponse.postValue(it)
            }.launchIn(viewModelScope)

        }
    }
}