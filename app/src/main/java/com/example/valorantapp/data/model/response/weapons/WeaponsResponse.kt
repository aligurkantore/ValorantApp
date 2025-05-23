package com.example.valorantapp.data.model.response.weapons


import com.google.gson.annotations.SerializedName

data class WeaponsResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: Int
)

data class Data(
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

data class WeaponStats(
    @SerializedName("adsStats")
    val adsStats: AdsStats,
    @SerializedName("airBurstStats")
    val airBurstStats: AirBurstStats,
    @SerializedName("altFireType")
    val altFireType: String,
    @SerializedName("altShotgunStats")
    val altShotgunStats: AltShotgunStats,
    @SerializedName("damageRanges")
    val damageRanges: List<DamageRange>,
    @SerializedName("equipTimeSeconds")
    val equipTimeSeconds: Double,
    @SerializedName("feature")
    val feature: String,
    @SerializedName("fireMode")
    val fireMode: String,
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

data class GridPosition(
    @SerializedName("column")
    val column: Int,
    @SerializedName("row")
    val row: Int
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

data class AirBurstStats(
    @SerializedName("burstDistance")
    val burstDistance: Double,
    @SerializedName("shotgunPelletCount")
    val shotgunPelletCount: Int
)

data class AltShotgunStats(
    @SerializedName("burstRate")
    val burstRate: Double,
    @SerializedName("shotgunPelletCount")
    val shotgunPelletCount: Int
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