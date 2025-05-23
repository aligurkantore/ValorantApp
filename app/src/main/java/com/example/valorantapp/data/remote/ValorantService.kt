package com.example.valorantapp.data.remote

import com.example.valorantapp.common.util.Resource
import com.example.valorantapp.data.model.response.agentdetail.AgentDetailResponse
import com.example.valorantapp.data.model.response.agents.AgentsResponse
import com.example.valorantapp.data.model.response.competitivetiers.CompetitivetiersResponse
import com.example.valorantapp.data.model.response.mapdetail.MapDetailResponse
import com.example.valorantapp.data.model.response.maps.MapsResponse
import com.example.valorantapp.data.model.response.weapons.WeaponsResponse
import com.example.valorantapp.data.model.response.weaponsdetail.WeaponDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ValorantService {

    @GET("v1/agents/?isPlayableCharacter=true")
    suspend fun getAgents(): Response<AgentsResponse>

    @GET("v1/agents/{agentUuid}")
    suspend fun getAgentDetail(
        @Path("agentUuid") agentUuid: String
    ): Response<AgentDetailResponse>

    @GET("v1/maps")
    suspend fun getMaps(): Response<MapsResponse>

    @GET("v1/maps/{mapUuid}")
    suspend fun getMapByUuid(
        @Path("mapUuid") mapUuid: String
    ): Response<MapDetailResponse>

    @GET("v1/weapons")
    suspend fun getWeapons(): Response<WeaponsResponse>

    @GET("v1/weapons/{weaponUuid}")
    suspend fun getWeaponByUuid(
        @Path("weaponUuid") weaponUuid: String
    ): Response<WeaponDetailResponse>

    @GET("v1/competitivetiers")
    suspend fun getCompetitiveTiers(): Response<CompetitivetiersResponse>
}