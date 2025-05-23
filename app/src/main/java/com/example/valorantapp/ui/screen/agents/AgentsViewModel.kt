package com.example.valorantapp.ui.screen.agents

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.valorantapp.common.base.BaseViewModel
import com.example.valorantapp.common.base.Effect
import com.example.valorantapp.common.base.Event
import com.example.valorantapp.common.base.State
import com.example.valorantapp.common.util.FailViewType
import com.example.valorantapp.domain.model.agents.AgentUIModel
import com.example.valorantapp.domain.usecase.agents.AgentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(
    private val agentsUseCase: AgentsUseCase
) : BaseViewModel<AgentsEvent, AgentsState, AgentsEffect>() {

    init {
        getAgents()
    }

    override fun setInitialState() = AgentsState(false)

    override fun handleEvents(event: AgentsEvent) {
        when (event) {
            is AgentsEvent.NavigateToDetailClick -> {
                setEffect { AgentsEffect.NavigateToDetail(event.uuid) }
            }
        }
    }

    private fun getAgents() = viewModelScope.launch {
        val result = agentsUseCase.invoke()
            .cachedIn(viewModelScope)
        setState {
            copy(agentsList = result)
        }

    }
}

sealed interface AgentsEvent : Event {
    data class NavigateToDetailClick(val uuid: String) : AgentsEvent
}

data class AgentsState(
    val isLoading: Boolean = false,
    val agentsList: Flow<PagingData<AgentUIModel>> = emptyFlow()
) : State

sealed interface AgentsEffect : Effect {
    data class NavigateToDetail(val uuid: String) : AgentsEffect
    data class ShowFail(val message: Int, val failViewType: FailViewType) : AgentsEffect
}