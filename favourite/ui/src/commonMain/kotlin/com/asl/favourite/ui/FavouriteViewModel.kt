package com.asl.favourite.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asl.favourite.domain.useCases.DeleteUseCase
import com.asl.favourite.domain.useCases.GetAllLocalCacheGamesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FavouriteViewModel(
    private val gtAllLocalCacheGamesUseCase: GetAllLocalCacheGamesUseCase,
    private val deleteUseCase: DeleteUseCase
) : ViewModel() {

    val games = gtAllLocalCacheGamesUseCase.invoke()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            emptyList()
        )

    fun delete(id: Int) = viewModelScope.launch {
        deleteUseCase.invoke(id)
    }

}