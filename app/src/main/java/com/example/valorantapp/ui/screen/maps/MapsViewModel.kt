package com.example.valorantapp.ui.screen.maps

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.valorantapp.common.base.BaseViewModel
import com.example.valorantapp.common.base.Effect
import com.example.valorantapp.common.base.Event
import com.example.valorantapp.common.base.State
import com.example.valorantapp.common.util.FailViewType
import com.example.valorantapp.domain.model.maps.MapUIModel
import com.example.valorantapp.domain.usecase.maps.MapsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val mapsUseCase: MapsUseCase
) : BaseViewModel<MapsEvent, MapsState, MapsEffect>(){

    init {
        getMaps()
    }

    override fun setInitialState() = MapsState(false)


    override fun handleEvents(event: MapsEvent) {
        when(event) {
            is MapsEvent.NavigateToMapDetail -> {
                setEffect { MapsEffect.NavigateToDetail(event.uuid) }
            }
        }
    }

    private fun getMaps() = viewModelScope.launch {
        val result = mapsUseCase.invoke()
            .cachedIn(viewModelScope)
        setState { copy(mapsList = result) }
    }
}

sealed interface MapsEvent: Event {
    data class NavigateToMapDetail(val uuid: String) : MapsEvent
}

data class MapsState(
    val isLoading: Boolean = false,
    val mapsList: Flow<PagingData<MapUIModel>> = emptyFlow()
): State

sealed interface MapsEffect: Effect {
    data class NavigateToDetail(val uuid: String) : MapsEffect
    data class ShowFail(val message: Int, val failViewType: FailViewType) : MapsEffect
}