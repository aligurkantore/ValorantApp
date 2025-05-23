package com.example.valorantapp.ui.screen.agents

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.valorantapp.ui.components.AgentListItem
import com.example.valorantapp.ui.navigation.Screen

@Composable
fun AgentsScreen(
    viewModel: AgentsViewModel = hiltViewModel(),
    navController: NavController
) {
    val context = LocalContext.current
    val state = viewModel.state.collectAsState().value
    val lazyPagingItems = state.agentsList.collectAsLazyPagingItems()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is AgentsEffect.NavigateToDetail -> {
                    navController.navigate("${Screen.AgentDetail.route}/${effect.uuid}")
                }

                is AgentsEffect.ShowFail -> {
                    Toast.makeText(context, context.getString(effect.message), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
    ) {
        LazyColumn {
            items(lazyPagingItems.itemCount) { index ->
                val agent = lazyPagingItems[index]
                agent?.let {
                    AgentListItem(agent = it) { uuid ->
                        viewModel.setEvent(AgentsEvent.NavigateToDetailClick(uuid))
                    }
                }
            }
        }
    }
}
