package com.example.valorantapp.ui.screen.weapondetail

import androidx.lifecycle.viewModelScope
import com.example.valorantapp.common.base.BaseViewModel
import com.example.valorantapp.common.base.Effect
import com.example.valorantapp.common.base.Event
import com.example.valorantapp.common.base.State
import com.example.valorantapp.common.util.FailViewType
import com.example.valorantapp.common.util.Resource
import com.example.valorantapp.domain.model.weapondetail.WeaponDetailUI
import com.example.valorantapp.domain.usecase.weapondetail.WeaponDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponDetailViewModel @Inject constructor(
    private val weaponDetailUseCase: WeaponDetailUseCase
) : BaseViewModel<WeaponDetailEvent, WeaponDetailState, WeaponDetailEffect>() {

    override fun setInitialState() = WeaponDetailState(false)

    override fun handleEvents(event: WeaponDetailEvent) {
        when (event) {
            is WeaponDetailEvent.OnBackClick -> {
                setEffect { WeaponDetailEffect.GoToBack }
            }
        }
    }

    fun getWeaponDetail(uuid: String) = viewModelScope.launch {
        weaponDetailUseCase.invoke(uuid)
            .onStart { setState { copy(isLoading = true) } }
            .onCompletion { setState { copy(isLoading = false) } }
            .collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        val agentDetail = result.data
                        setState { copy(weaponDetail = agentDetail) }
                    }

                    is Resource.Fail -> {
                        setEffect {
                            WeaponDetailEffect.ShowFail(
                                result.message,
                                result.failViewType
                            )
                        }
                    }
                }
            }
    }
}

sealed interface WeaponDetailEvent : Event {
    data object OnBackClick : WeaponDetailEvent
}

data class WeaponDetailState(
    val isLoading: Boolean = false,
    val weaponDetail: WeaponDetailUI? = null
) : State

sealed interface WeaponDetailEffect : Effect {
    data class ShowFail(val message: Int, val failViewType: FailViewType) : WeaponDetailEffect
    data object GoToBack : WeaponDetailEffect
}