package com.example.valorantapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Shield

data class BottomNavItem(
    val screen: Screen,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(Screen.Agents, Icons.Default.Face),
    BottomNavItem(Screen.Maps, Icons.Default.Map),
    BottomNavItem(Screen.Weapons, Icons.Default.Shield),
    BottomNavItem(Screen.CompetitiveTiers, Icons.Default.Flag)
)