package com.example.valorantapp.ui.screen.agentdetail

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.valorantapp.ui.components.AgentAbilityItem
import com.example.valorantapp.ui.components.BackButton

@Composable
fun AgentDetailScreen(
    uuid: String,
    viewModel: AgentDetailViewModel = hiltViewModel(),
    navController: NavController
) {

    val context = LocalContext.current
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.apply {
            getAgentDetail(uuid)

            effect.collect { effect ->
                when (effect) {
                    is AgentDetailEffect.ShowFail -> {
                        Toast.makeText(
                            context,
                            context.getString(effect.message),
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    is AgentDetailEffect.GoToBack -> {
                        navController.popBackStack()
                    }
                }
            }
        }
    }

    state.agentDetail?.let { agentDetail ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            BackButton(
                onBackClick = { viewModel.setEvent(AgentDetailEvent.OnBackClick) }
            )
            Text(
                text = "AGENT DETAIL",
                color = Color.Red,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            AsyncImage(
                model = agentDetail.bustImageUrl,
                contentDescription = agentDetail.displayName,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
            )

            Text(
                text = agentDetail.displayName.uppercase(),
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Description",
                color = Color.Red,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(4.dp)
            )

            Text(
                text = agentDetail.description,
                color = Color.White,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(12.dp)
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                val abilities = agentDetail.abilities
                items(abilities.size) { index ->
                    val ability = abilities[index]
                    AgentAbilityItem(ability = ability) { name ->
                        Toast.makeText(context, name, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}