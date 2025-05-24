package com.example.valorantapp.domain.model.maps

data class MapUIModel(
    val uuid: String,
    val displayName: String,
    val displayIcon: String? = null,
    val description: String? = null
)
