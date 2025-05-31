package com.example.valorantapp.ui.screen.weapondetail

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
import com.example.valorantapp.ui.components.BackButton

@Composable
fun WeaponDetailScreen(
    uuid: String,
    viewModel: WeaponDetailViewModel = hiltViewModel(),
    navController: NavController
) {
    val context = LocalContext.current
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.apply {
            getWeaponDetail(uuid)

            effect.collect { effect ->
                when (effect) {
                    is WeaponDetailEffect.ShowFail -> {
                        Toast.makeText(
                            context,
                            context.getString(effect.message),
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    is WeaponDetailEffect.GoToBack -> {
                        navController.popBackStack()
                    }
                }
            }
        }
    }

    state.weaponDetail?.let { weaponDetail ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            BackButton(
                onBackClick = { viewModel.setEvent(WeaponDetailEvent.OnBackClick) }
            )
            Text(
                text = weaponDetail.name.uppercase(),
                color = Color.Red,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            AsyncImage(
                model = weaponDetail.imageUrl,
                contentDescription = weaponDetail.name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
            )

            weaponDetail.category?.let {
                Text(
                    text = it,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

            weaponDetail.fireRate?.let {
                Text(
                    text = "$it rpm",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(4.dp)
                )
            }

            weaponDetail.magazineSize?.let {
                Text(
                    text = "$it rounds",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(12.dp)
                )
            }

            weaponDetail.cost?.let {
                Text(
                    text = "$it$",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(12.dp)
                )
            }

        }
    }
}