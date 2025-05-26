package com.example.valorantapp.data.model.response.weaponsdetail


import com.google.gson.annotations.SerializedName

data class WeaponDetailResponse(
    @SerializedName("data")
    val weaponDetailResponseItem: WeaponDetailResponseItem,
    @SerializedName("status")
    val status: Int
)

data class WeaponDetailResponseItem(
    @SerializedName("assetPath")
    val assetPath: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("defaultSkinUuid")
    val defaultSkinUuid: String,
    @SerializedName("displayIcon")
    val displayIcon: String,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("killStreamIcon")
    val killStreamIcon: String,
    @SerializedName("shopData")
    val shopData: ShopData,
    @SerializedName("skins")
    val skins: List<Skin>,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("weaponStats")
    val weaponStats: WeaponStats
)

data class WeaponStats(
    @SerializedName("adsStats")
    val adsStats: AdsStats,
    @SerializedName("airBurstStats")
    val airBurstStats: Any,
    @SerializedName("altFireType")
    val altFireType: String,
    @SerializedName("altShotgunStats")
    val altShotgunStats: Any,
    @SerializedName("damageRanges")
    val damageRanges: List<DamageRange>,
    @SerializedName("equipTimeSeconds")
    val equipTimeSeconds: Double,
    @SerializedName("feature")
    val feature: String,
    @SerializedName("fireMode")
    val fireMode: Any,
    @SerializedName("fireRate")
    val fireRate: Double,
    @SerializedName("firstBulletAccuracy")
    val firstBulletAccuracy: Double,
    @SerializedName("magazineSize")
    val magazineSize: Int,
    @SerializedName("reloadTimeSeconds")
    val reloadTimeSeconds: Double,
    @SerializedName("runSpeedMultiplier")
    val runSpeedMultiplier: Double,
    @SerializedName("shotgunPelletCount")
    val shotgunPelletCount: Int,
    @SerializedName("wallPenetration")
    val wallPenetration: String
)

data class AdsStats(
    @SerializedName("burstCount")
    val burstCount: Int,
    @SerializedName("fireRate")
    val fireRate: Double,
    @SerializedName("firstBulletAccuracy")
    val firstBulletAccuracy: Double,
    @SerializedName("runSpeedMultiplier")
    val runSpeedMultiplier: Double,
    @SerializedName("zoomMultiplier")
    val zoomMultiplier: Double
)

data class Chroma(
    @SerializedName("assetPath")
    val assetPath: String,
    @SerializedName("displayIcon")
    val displayIcon: String,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("fullRender")
    val fullRender: String,
    @SerializedName("streamedVideo")
    val streamedVideo: String,
    @SerializedName("swatch")
    val swatch: String,
    @SerializedName("uuid")
    val uuid: String
)

data class Level(
    @SerializedName("assetPath")
    val assetPath: String,
    @SerializedName("displayIcon")
    val displayIcon: String,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("levelItem")
    val levelItem: String,
    @SerializedName("streamedVideo")
    val streamedVideo: String,
    @SerializedName("uuid")
    val uuid: String
)

data class Skin(
    @SerializedName("assetPath")
    val assetPath: String,
    @SerializedName("chromas")
    val chromas: List<Chroma>,
    @SerializedName("contentTierUuid")
    val contentTierUuid: String,
    @SerializedName("displayIcon")
    val displayIcon: String,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("levels")
    val levels: List<Level>,
    @SerializedName("themeUuid")
    val themeUuid: String,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("wallpaper")
    val wallpaper: String
)

data class ShopData(
    @SerializedName("assetPath")
    val assetPath: String,
    @SerializedName("canBeTrashed")
    val canBeTrashed: Boolean,
    @SerializedName("category")
    val category: String,
    @SerializedName("categoryText")
    val categoryText: String,
    @SerializedName("cost")
    val cost: Int,
    @SerializedName("gridPosition")
    val gridPosition: GridPosition,
    @SerializedName("image")
    val image: Any,
    @SerializedName("newImage")
    val newImage: String,
    @SerializedName("newImage2")
    val newImage2: Any,
    @SerializedName("shopOrderPriority")
    val shopOrderPriority: Int
)

data class DamageRange(
    @SerializedName("bodyDamage")
    val bodyDamage: Int,
    @SerializedName("headDamage")
    val headDamage: Double,
    @SerializedName("legDamage")
    val legDamage: Double,
    @SerializedName("rangeEndMeters")
    val rangeEndMeters: Int,
    @SerializedName("rangeStartMeters")
    val rangeStartMeters: Int
)

data class GridPosition(
    @SerializedName("column")
    val column: Int,
    @SerializedName("row")
    val row: Int
)