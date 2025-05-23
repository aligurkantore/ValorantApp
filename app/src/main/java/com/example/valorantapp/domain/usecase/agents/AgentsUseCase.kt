package com.example.valorantapp.domain.usecase.agents

import androidx.paging.PagingData
import androidx.paging.map
import com.example.valorantapp.domain.mapper.toUIModel
import com.example.valorantapp.domain.model.agents.AgentUIModel
import com.example.valorantapp.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AgentsUseCase @Inject constructor(private val repository: ValorantRepository) {

    suspend fun invoke(): Flow<PagingData<AgentUIModel>> {
        return repository.getAgents().map { pagingData ->
            pagingData.map { result ->
                result.toUIModel()
            }
        }
    }
}