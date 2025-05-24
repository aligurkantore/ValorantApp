package com.example.valorantapp.domain.repository

import androidx.paging.PagingData
import com.example.valorantapp.common.util.Resource
import com.example.valorantapp.data.model.response.agentdetail.AgentDetailResponse
import com.example.valorantapp.data.model.response.agents.AgentResponseItem
import com.example.valorantapp.data.model.response.mapdetail.MapDetailResponse
import com.example.valorantapp.data.model.response.maps.MapResponseItem
import kotlinx.coroutines.flow.Flow

interface ValorantRepository {

    suspend fun getAgents() : Flow<PagingData<AgentResponseItem>>

    suspend fun getAgentDetail(uuid: String): Resource<AgentDetailResponse>

    suspend fun getMaps() : Flow<PagingData<MapResponseItem>>

    suspend fun getMapDetails(uuid: String): Resource<MapDetailResponse>
}