package com.example.valorantapp.domain.mapper

import com.example.valorantapp.data.model.response.agentdetail.AgentDetailResponseItem
import com.example.valorantapp.data.model.response.agents.AgentResponseItem
import com.example.valorantapp.data.model.response.mapdetail.MapDetailResponseItem
import com.example.valorantapp.data.model.response.maps.MapResponseItem
import com.example.valorantapp.data.model.response.weapons.WeaponResponseItem
import com.example.valorantapp.data.model.response.weaponsdetail.WeaponDetailResponseItem
import com.example.valorantapp.domain.model.agentdetail.AbilityUI
import com.example.valorantapp.domain.model.agentdetail.AgentDetailUI
import com.example.valorantapp.domain.model.agents.AgentUIModel
import com.example.valorantapp.domain.model.mapdetail.MapDetailUI
import com.example.valorantapp.domain.model.maps.MapUIModel
import com.example.valorantapp.domain.model.weapondetail.WeaponDetailUI
import com.example.valorantapp.domain.model.weapons.WeaponUI

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

fun MapDetailResponseItem.mapToUIModel(): MapDetailUI {
    return MapDetailUI(
        displayName = this.displayName ?: "",
        tacticalDescription = this.tacticalDescription,
        coordinates = this.coordinates,
        displayIconUrl = this.displayIcon,
        splashUrl = this.splash,
        stylizedBackgroundImageUrl = this.stylizedBackgroundImage,
        premierBackgroundImageUrl = this.premierBackgroundImage,
        listViewIcon = this.listViewIcon
    )
}

fun WeaponResponseItem.mapToUIModel(): WeaponUI {
    return WeaponUI(
        uuid = uuid,
        name = displayName,
        iconUrl = displayIcon
    )
}

fun WeaponDetailResponseItem.toWeaponUI(): WeaponDetailUI {
    return WeaponDetailUI(
        name = displayName,
        imageUrl = displayIcon,
        magazineSize = weaponStats?.magazineSize?.toString().orEmpty(),
        fireRate = weaponStats?.fireRate?.toString().orEmpty(),
        cost = shopData?.cost?.toString().orEmpty(),
        category = category
    )
}



