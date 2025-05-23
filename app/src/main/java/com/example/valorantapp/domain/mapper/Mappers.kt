package com.example.valorantapp.domain.mapper

import com.example.valorantapp.data.model.response.agentdetail.AgentDetailResponseItem
import com.example.valorantapp.data.model.response.agents.AgentResponseItem
import com.example.valorantapp.data.model.response.maps.MapResponseItem
import com.example.valorantapp.domain.model.agentdetail.AbilityUI
import com.example.valorantapp.domain.model.agentdetail.AgentDetailUI
import com.example.valorantapp.domain.model.agents.AgentUIModel
import com.example.valorantapp.domain.model.maps.MapUIModel

fun AgentResponseItem.toUIModel(): AgentUIModel {
    return AgentUIModel(
        uuid = uuid,
        name = displayName,
        description = description,
        imageUrl = displayIcon
    )
}

fun AgentDetailResponseItem.mapToUIModel(): AgentDetailUI {
    return AgentDetailUI(
        displayName = this.displayName,
        bustImageUrl = this.bustPortrait,
        description = this.description,
        roleDisplayName = this.role.displayName,
        roleImageUrl = this.role.displayIcon,
        abilities = this.abilities.map {
            AbilityUI(
                name = it.displayName,
                url = it.displayIcon
            )
        }
    )
}

fun MapResponseItem.toUIModel(): MapUIModel {
    return MapUIModel(
        uuid = this.uuid,
        displayName = this.displayName,
        displayIcon = this.displayIcon,
        description = this.tacticalDescription
    )
}
