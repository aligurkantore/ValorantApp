package com.example.valorantapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.valorantapp.ui.screen.agentdetail.AgentDetailScreen
import com.example.valorantapp.ui.screen.agents.AgentsScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Agents.route
    ) {
        composable(Screen.Agents.route) {
            AgentsScreen(navController = navController)
        }

        composable("${Screen.AgentDetail.route}/{uuid}") { backStackEntry ->
            val uuid = backStackEntry.arguments?.getString("uuid") ?: ""
            AgentDetailScreen(uuid = uuid, navController = navController)
        }
    }
}