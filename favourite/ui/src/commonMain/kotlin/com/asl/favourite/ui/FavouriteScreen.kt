package com.asl.favourite.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.asl.common.domain.model.Game
import com.asl.common.ui.GameItem
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun FavouriteScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onDetails: (Int) -> Unit,
) {

    val viewModel = koinViewModel<FavouriteViewModel>()
    val games = viewModel.games.collectAsStateWithLifecycle()

    FavouriteScreenContent(
        modifier = modifier.fillMaxSize(),
        games = games.value,
        onBackClick = onBackClick,
        onDetails = onDetails,
        onDelete = { id ->
            viewModel.delete(id)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteScreenContent(
    modifier: Modifier = Modifier,
    games: List<Game>,
    onBackClick: () -> Unit,
    onDetails: (Int) -> Unit,
    onDelete: (Int) -> Unit
) {

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Favourite")
                }, navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.clickable { onBackClick() }
                    )
                }
            )
        }
    ) {
        if (games.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Nothing Found")
            }
        } else {
            LazyColumn(modifier = Modifier.padding(it).fillMaxSize()) {
                items(games) { item ->
                    GameItem(
                        isDeleteShow = true,
                        item = item,
                        onClick = onDetails,
                        onDeleteClick = onDelete
                    )
                }
            }
        }


    }

}
