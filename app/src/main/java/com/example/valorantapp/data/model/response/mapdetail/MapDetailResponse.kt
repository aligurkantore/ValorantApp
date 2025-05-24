package com.example.valorantapp.data.model.response.mapdetail


import com.google.gson.annotations.SerializedName

data class MapDetailResponse(
    @SerializedName("data")
    val mapDetailResponseItem: MapDetailResponseItem,
    @SerializedName("status")
    val status: Int
)

data class MapDetailResponseItem(
    @SerializedName("assetPath")
    val assetPath: String,
    @SerializedName("callouts")
    val callouts: List<Callout>,
    @SerializedName("coordinates")
    val coordinates: String,
    @SerializedName("displayIcon")
    val displayIcon: String,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("listViewIcon")
    val listViewIcon: String,
    @SerializedName("listViewIconTall")
    val listViewIconTall: String,
    @SerializedName("mapUrl")
    val mapUrl: String,
    @SerializedName("narrativeDescription")
    val narrativeDescription: Any,
    @SerializedName("premierBackgroundImage")
    val premierBackgroundImage: String,
    @SerializedName("splash")
    val splash: String,
    @SerializedName("stylizedBackgroundImage")
    val stylizedBackgroundImage: String,
    @SerializedName("tacticalDescription")
    val tacticalDescription: String,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("xMultiplier")
    val xMultiplier: Double,
    @SerializedName("xScalarToAdd")
    val xScalarToAdd: Double,
    @SerializedName("yMultiplier")
    val yMultiplier: Double,
    @SerializedName("yScalarToAdd")
    val yScalarToAdd: Double
)

data class Callout(
    @SerializedName("location")
    val location: Location,
    @SerializedName("regionName")
    val regionName: String,
    @SerializedName("superRegionName")
    val superRegionName: String
)

data class Location(
    @SerializedName("x")
    val x: Double,
    @SerializedName("y")
    val y: Double
)