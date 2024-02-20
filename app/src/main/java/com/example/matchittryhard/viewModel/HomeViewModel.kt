package com.example.matchittryhard.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.matchittryhard.api.PositionService
import com.example.matchittryhard.model.Position
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {


    val positions: MutableLiveData<List<Position>> = MutableLiveData()
    private val client = PositionService.create()


    init {
        getPositions()
    }

    fun getPositions() {
        viewModelScope.launch {
            positions.postValue(client.getPositions())
        }
    }
}