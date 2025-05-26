package com.example.valorantapp.ui.screen.mapdetail

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.valorantapp.ui.components.BackButton

@Composable
fun MapDetailScreen(
    uuid: String,
    viewModel: MapDetailViewModel = hiltViewModel(),
    navController: NavController
) {
    val context = LocalContext.current
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.apply {
            getMapDetail(uuid)

            effect.collect { effect ->
                when (effect) {
                    is MapDetailEffect.GoToBack -> {
                        navController.popBackStack()
                    }

                    is MapDetailEffect.ShowFail -> {
                        Toast.makeText(
                            context,
                            context.getString(effect.message),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    state.mapDetail?.let { mapDetail ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            BackButton(
                onBackClick = { viewModel.setEvent(MapDetailEvent.OnBackClick) }
            )
            Text(
                text = mapDetail.displayName.uppercase(),
                color = Color.Red,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            AsyncImage(
                model = mapDetail.splashUrl,
                contentDescription = mapDetail.displayName,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
            )
        }
    }
}