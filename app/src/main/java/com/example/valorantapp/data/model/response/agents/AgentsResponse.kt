package com.example.valorantapp.data.model.response.agents


import com.google.gson.annotations.SerializedName

data class AgentsResponse(
    @SerializedName("data")
    val agentResponseItems: List<AgentResponseItem>,
    @SerializedName("status")
    val status: Int
)

data class AgentResponseItem(
    @SerializedName("abilities")
    val abilities: List<Ability>,
    @SerializedName("assetPath")
    val assetPath: String,
    @SerializedName("background")
    val background: String,
    @SerializedName("backgroundGradientColors")
    val backgroundGradientColors: List<String>,
    @SerializedName("bustPortrait")
    val bustPortrait: String,
    @SerializedName("characterTags")
    val characterTags: List<String>,
    @SerializedName("description")
    val description: String,
    @SerializedName("developerName")
    val developerName: String,
    @SerializedName("displayIcon")
    val displayIcon: String,
    @SerializedName("displayIconSmall")
    val displayIconSmall: String,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("fullPortrait")
    val fullPortrait: String,
    @SerializedName("fullPortraitV2")
    val fullPortraitV2: String,
    @SerializedName("isAvailableForTest")
    val isAvailableForTest: Boolean,
    @SerializedName("isBaseContent")
    val isBaseContent: Boolean,
    @SerializedName("isFullPortraitRightFacing")
    val isFullPortraitRightFacing: Boolean,
    @SerializedName("isPlayableCharacter")
    val isPlayableCharacter: Boolean,
    @SerializedName("killfeedPortrait")
    val killfeedPortrait: String,
    @SerializedName("recruitmentData")
    val recruitmentData: RecruitmentData,
    @SerializedName("releaseDate")
    val releaseDate: String,
    @SerializedName("role")
    val role: Role,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("voiceLine")
    val voiceLine: Any
)

data class Ability(
    @SerializedName("description")
    val description: String,
    @SerializedName("displayIcon")
    val displayIcon: String,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("slot")
    val slot: String
)

data class RecruitmentData(
    @SerializedName("counterId")
    val counterId: String,
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("levelVpCostOverride")
    val levelVpCostOverride: Int,
    @SerializedName("milestoneId")
    val milestoneId: String,
    @SerializedName("milestoneThreshold")
    val milestoneThreshold: Int,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("useLevelVpCostOverride")
    val useLevelVpCostOverride: Boolean
)

data class Role(
    @SerializedName("assetPath")
    val assetPath: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("displayIcon")
    val displayIcon: String,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("uuid")
    val uuid: String
)