package com.example.valorantapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.valorantapp.ui.screen.agentdetail.AgentDetailScreen
import com.example.valorantapp.ui.screen.agents.AgentsScreen
import com.example.valorantapp.ui.screen.competitivetiers.CompetitivetiersScreen
import com.example.valorantapp.ui.screen.mapdetail.MapDetailScreen
import com.example.valorantapp.ui.screen.maps.MapsScreen
import com.example.valorantapp.ui.screen.weapons.WeaponsScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Agents.route,
        modifier = modifier
    ) {
        composable(Screen.Agents.route) {
            AgentsScreen(navController = navController)
        }

        composable("${Screen.AgentDetail.route}/{uuid}") { backStackEntry ->
            val uuid = backStackEntry.arguments?.getString("uuid") ?: ""
            AgentDetailScreen(uuid = uuid, navController = navController)
        }

        composable(Screen.Maps.route) {
            MapsScreen(navController = navController)
        }

        composable("${Screen.MapDetail.route}/{uuid}") { backStackEntry ->
            val uuid = backStackEntry.arguments?.getString("uuid") ?: ""
            MapDetailScreen(uuid = uuid, navController = navController)
        }

        composable(Screen.Weapons.route) {
            WeaponsScreen(navController = navController)
        }

        composable(Screen.CompetitiveTiers.route) {
            CompetitivetiersScreen(navController = navController)
        }
    }
}