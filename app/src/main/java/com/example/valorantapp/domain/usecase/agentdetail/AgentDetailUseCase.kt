package com.example.valorantapp.domain.usecase.agentdetail

import com.example.valorantapp.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AgentDetailUseCase @Inject constructor(private val repository: ValorantRepository) {

    operator fun invoke(uuid: String) = flow {
        emit(
            repository.getAgentDetail(uuid)
        )
    }
}