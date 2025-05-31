package com.example.valorantapp.data.repository

import androidx.paging.PagingData
import com.example.valorantapp.common.base.BaseRepository
import com.example.valorantapp.common.util.onSuccess
import com.example.valorantapp.data.model.response.agents.AgentResponseItem
import com.example.valorantapp.data.model.response.maps.MapResponseItem
import com.example.valorantapp.data.model.response.weapons.WeaponResponseItem
import com.example.valorantapp.data.remote.ValorantService
import com.example.valorantapp.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow

class ValorantRepositoryImpl(
    private val service: ValorantService
) : BaseRepository(), ValorantRepository {

    override suspend fun getAgents(): Flow<PagingData<AgentResponseItem>> {
        return safeApiCallPaging { _, _ ->
            safeApiCall { service.getAgents() }.onSuccess { response ->
                response.agentResponseItems
            }
        }
    }

    override suspend fun getAgentDetail(uuid: String) = safeApiCall {
        service.getAgentDetail(uuid)
    }

    override suspend fun getMaps(): Flow<PagingData<MapResponseItem>> {
        return safeApiCallPaging { _, _ ->
            safeApiCall { service.getMaps() }.onSuccess { response ->
                response.mapResponseItems
            }
        }
    }

    override suspend fun getMapDetails(uuid: String) = safeApiCall {
        service.getMapDetail(uuid)
    }

    override suspend fun getWeapons(): Flow<PagingData<WeaponResponseItem>> {
        return safeApiCallPaging { _, _ ->
            safeApiCall { service.getWeapons() }.onSuccess { response ->
                response.weaponResponseItems
            }
        }
    }

    override suspend fun getWeaponDetails(uuid: String) = safeApiCall {
        service.getWeaponDetail(uuid)
    }


}