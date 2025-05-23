package com.example.valorantapp.data.repository

import androidx.paging.PagingData
import com.example.valorantapp.common.base.BaseRepository
import com.example.valorantapp.common.util.onSuccess
import com.example.valorantapp.data.model.response.agents.AgentResponseItem
import com.example.valorantapp.data.remote.ValorantService
import com.example.valorantapp.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow

class ValorantRepositoryImpl(
    private val service: ValorantService
) : BaseRepository(), ValorantRepository {

    override suspend fun getAgents(): Flow<PagingData<AgentResponseItem>> {
        return safeApiCallPaging { page, pageSize ->
            safeApiCall { service.getAgents() }.onSuccess { response ->
                response.agentResponseItems
            }
        }
    }

    override suspend fun getAgentDetail(uuid: String) = safeApiCall {
        service.getAgentDetail(uuid)
    }


}