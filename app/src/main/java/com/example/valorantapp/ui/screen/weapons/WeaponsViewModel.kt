package com.example.valorantapp.ui.screen.weapons

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.valorantapp.common.base.BaseViewModel
import com.example.valorantapp.common.base.Effect
import com.example.valorantapp.common.base.Event
import com.example.valorantapp.common.base.State
import com.example.valorantapp.common.util.FailViewType
import com.example.valorantapp.domain.model.weapons.WeaponUI
import com.example.valorantapp.domain.usecase.weapons.WeaponsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponsViewModel @Inject constructor(
    private val weaponsUseCase: WeaponsUseCase
) : BaseViewModel<WeaponsEvent, WeaponsState, WeaponsEffect>() {

    init {
        getWeapons()
    }

    override fun setInitialState() = WeaponsState(false)

    override fun handleEvents(event: WeaponsEvent) {
        when (event) {
            is WeaponsEvent.NavigateToDetailClick -> {
                setEffect { WeaponsEffect.NavigateToWeaponDetail(event.uuid) }
            }
        }
    }

    private fun getWeapons() = viewModelScope.launch {
        val result = weaponsUseCase.invoke()
            .cachedIn(viewModelScope)
        setState {
            copy(weaponsList = result)
        }

    }
}

sealed interface WeaponsEvent : Event {
    data class NavigateToDetailClick(val uuid: String) : WeaponsEvent
}

data class WeaponsState(
    val isLoading: Boolean = false,
    val weaponsList: Flow<PagingData<WeaponUI>> = emptyFlow()
) : State

sealed interface WeaponsEffect : Effect {
    data class NavigateToWeaponDetail(val uuid: String) : WeaponsEffect
    data class ShowFail(val message: Int, val failViewType: FailViewType) : WeaponsEffect
}