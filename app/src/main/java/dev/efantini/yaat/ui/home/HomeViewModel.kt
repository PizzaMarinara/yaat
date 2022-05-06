package dev.efantini.yaat.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dev.efantini.yaat.ui.home.states.HomeUiState

class HomeViewModel : ViewModel() {

    var homeUiState by mutableStateOf(HomeUiState())
        private set

    init {
        // load stuff, initialize repositories
    }

    fun setName(name: String) {
        homeUiState = homeUiState.copy(name = name)
    }
}
