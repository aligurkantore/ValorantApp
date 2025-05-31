package com.example.valorantapp.ui.screen.weapons

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.valorantapp.ui.components.WeaponListItem
import com.example.valorantapp.ui.navigation.Screen

@Composable
fun WeaponsScreen(
    viewModel: WeaponsViewModel = hiltViewModel(),
    navController: NavController
) {
    val context = LocalContext.current
    val state by viewModel.state.collectAsState()
    val lazyPagingItems = state.weaponsList.collectAsLazyPagingItems()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is WeaponsEffect.NavigateToWeaponDetail -> {
                    navController.navigate("${Screen.WeaponDetail.route}/${effect.uuid}")
                }

                is WeaponsEffect.ShowFail -> {
                    Toast.makeText(context, context.getString(effect.message), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
    ) {
        Text(
            text = "WEAPONS",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Red,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
                .align(Alignment.CenterHorizontally)
        )

        LazyColumn(
            contentPadding = PaddingValues(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(lazyPagingItems.itemCount) { index ->
                val map = lazyPagingItems[index]
                map?.let {
                    WeaponListItem (weapon = it) { uuid ->
                        viewModel.setEvent(WeaponsEvent.NavigateToDetailClick(uuid))
                    }
                }
            }
        }
    }
}