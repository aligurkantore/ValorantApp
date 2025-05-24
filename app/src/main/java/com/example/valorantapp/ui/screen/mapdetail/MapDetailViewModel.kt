package com.example.valorantapp.ui.screen.mapdetail

import androidx.lifecycle.viewModelScope
import com.example.valorantapp.common.base.BaseViewModel
import com.example.valorantapp.common.base.Effect
import com.example.valorantapp.common.base.Event
import com.example.valorantapp.common.base.State
import com.example.valorantapp.common.util.FailViewType
import com.example.valorantapp.common.util.Resource
import com.example.valorantapp.data.model.response.mapdetail.MapDetailResponseItem
import com.example.valorantapp.domain.usecase.mapdetail.MapDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapDetailViewModel @Inject constructor(
    private val mapDetailUseCase: MapDetailUseCase
) : BaseViewModel<MapDetailEvent, MapDetailState, MapDetailEffect>() {
    override fun setInitialState() = MapDetailState(false)

    override fun handleEvents(event: MapDetailEvent) {
        TODO("Not yet implemented")
    }

    fun getMapDetail(uuid: String) = viewModelScope.launch {
        mapDetailUseCase.invoke(uuid)
            .onStart { setState { copy(isLoading = true) } }
            .onCompletion { setState { copy(isLoading = false) } }
            .collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        val mapDetail = result.data
                        setState { copy(mapDetail = mapDetail) }
                    }

                    is Resource.Fail -> {
                        setEffect {
                            MapDetailEffect.ShowFail(
                                result.message,
                                result.failViewType
                            )
                        }
                    }
                }
            }
    }
}

sealed interface MapDetailEvent : Event {
    data object OnBackClick: MapDetailEvent
}

data class MapDetailState(
    val isLoading: Boolean = false,
    val mapDetail: MapDetailResponseItem? = null
) : State

sealed interface MapDetailEffect : Effect {
    data class ShowFail(val message: Int, val failViewType: FailViewType) : MapDetailEffect
    data object GoToBack : MapDetailEffect

}