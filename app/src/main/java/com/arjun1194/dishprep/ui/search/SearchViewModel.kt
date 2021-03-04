package com.arjun1194.dishprep.ui.search

import android.provider.ContactsContract
import androidx.lifecycle.*
import com.arjun1194.dishprep.data.model.DataResponse
import com.arjun1194.dishprep.data.model.SearchResponse
import com.arjun1194.dishprep.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
    ) : ViewModel() {

    private val _searchResponse = MutableLiveData<DataResponse<SearchResponse>>();

    val searchResponse = _searchResponse as LiveData<DataResponse<SearchResponse>>;

    fun getSearchResults(query: String) {
        viewModelScope.launch {
            recipeRepository.getSearchResponse(query).onEach {
                _searchResponse.postValue(it)
            }.launchIn(viewModelScope)

        }
    }

}