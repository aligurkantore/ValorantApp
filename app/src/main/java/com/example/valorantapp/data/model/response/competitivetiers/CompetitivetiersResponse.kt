package com.example.valorantapp.data.model.response.competitivetiers


import com.google.gson.annotations.SerializedName

data class CompetitivetiersResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: Int
)

data class Data(
    @SerializedName("assetObjectName")
    val assetObjectName: String,
    @SerializedName("assetPath")
    val assetPath: String,
    @SerializedName("tiers")
    val tiers: List<Tier>,
    @SerializedName("uuid")
    val uuid: String
)

data class Tier(
    @SerializedName("backgroundColor")
    val backgroundColor: String,
    @SerializedName("color")
    val color: String,
    @SerializedName("division")
    val division: String,
    @SerializedName("divisionName")
    val divisionName: String,
    @SerializedName("largeIcon")
    val largeIcon: String,
    @SerializedName("rankTriangleDownIcon")
    val rankTriangleDownIcon: String,
    @SerializedName("rankTriangleUpIcon")
    val rankTriangleUpIcon: String,
    @SerializedName("smallIcon")
    val smallIcon: String,
    @SerializedName("tier")
    val tier: Int,
    @SerializedName("tierName")
    val tierName: String
)