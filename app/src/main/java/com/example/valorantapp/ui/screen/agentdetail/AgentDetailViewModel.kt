package com.example.valorantapp.ui.screen.agentdetail

import androidx.lifecycle.viewModelScope
import com.example.valorantapp.common.base.BaseViewModel
import com.example.valorantapp.common.base.Effect
import com.example.valorantapp.common.base.Event
import com.example.valorantapp.common.base.State
import com.example.valorantapp.common.util.FailViewType
import com.example.valorantapp.common.util.Resource
import com.example.valorantapp.domain.model.agentdetail.AgentDetailUI
import com.example.valorantapp.domain.usecase.agentdetail.AgentDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentDetailViewModel @Inject constructor(
    private val agentDetailUseCase: AgentDetailUseCase
) : BaseViewModel<AgentDetailEvent, AgentDetailState, AgentDetailEffect>() {

    override fun setInitialState() = AgentDetailState(false)

    override fun handleEvents(event: AgentDetailEvent) {
        when (event) {
            is AgentDetailEvent.OnBackClick -> {
                setEffect { AgentDetailEffect.GoToBack }
            }
        }
    }

    fun getAgentDetail(uuid: String) = viewModelScope.launch {
        agentDetailUseCase.invoke(uuid)
            .onStart { setState { copy(isLoading = true) } }
            .onCompletion { setState { copy(isLoading = false) } }
            .collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        val agentDetail = result.data
                        setState { copy(agentDetail = agentDetail) }
                    }

                    is Resource.Fail -> {
                        setEffect {
                            AgentDetailEffect.ShowFail(
                                result.message,
                                result.failViewType
                            )
                        }
                    }
                }
            }
    }
}

sealed interface AgentDetailEvent : Event {
    data object OnBackClick : AgentDetailEvent
}

data class AgentDetailState(
    val isLoading: Boolean = false,
    val agentDetail: AgentDetailUI? = null
) : State

sealed interface AgentDetailEffect : Effect {
    data class ShowFail(val message: Int, val failViewType: FailViewType) : AgentDetailEffect
    data object GoToBack : AgentDetailEffect
}