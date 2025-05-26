package com.example.valorantapp.ui.navigation

sealed class Screen(val route: String, val title: String) {
    object Agents : Screen("agents_screen", "Agents")
    object AgentDetail : Screen("agent_detail_screen","AgentDetail")
    object Maps : Screen("maps_screen","Maps")
    object MapDetail : Screen("map_detail_screen","MapDetail")
    object Weapons : Screen("weapons_screen","Weapons")
    object WeaponDetail : Screen("weapon_detail_screen","WeaponDetail")
}