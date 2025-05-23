package com.example.valorantapp.domain.model.agentdetail

data class AgentDetailUI(
    val displayName: String,
    val bustImageUrl: String,
    val description: String,
    val roleDisplayName: String,
    val roleImageUrl: String,
    val abilities: List<AbilityUI>
)

data class AbilityUI(
    val name: String,
    val url: String
)
