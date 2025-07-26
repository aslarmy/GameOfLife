package com.asl.game.ui.game

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    onFavouriteClick: () -> Unit,
    onSearchClick: () -> Unit,
    onClick: (Int) -> Unit,
) {

    val viewModel = koinViewModel<GameViewModel>()

    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    GameScreenContent(
        modifier = modifier.fillMaxSize(),
        uiState = uiState.value,
        onFavouriteClick = onFavouriteClick,
        onSearchClick = onSearchClick,
        onClick = onClick
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreenContent(
    modifier: Modifier = Modifier,
    uiState: GameScreen.UiState,
    onFavouriteClick: () -> Unit,
    onSearchClick: () -> Unit,
    onClick: (Int) -> Unit,
) {

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Gamopedia") },
                actions = {

                    IconButton(
                        onClick = onSearchClick,
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    }

                    IconButton(
                        onClick = onFavouriteClick,
                    ) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
    ) { paddingValues ->

        if (uiState.isLoading) {
            Box(
                Modifier.fillMaxSize().padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        if (uiState.error.isNotBlank()) {
            Box(
                Modifier.fillMaxSize().padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(uiState.error)
            }
        }

        uiState.data?.let { data ->
            LazyColumn(modifier = modifier.fillMaxSize().padding(paddingValues)) {
                items(data) {
                    Card(
                        modifier = Modifier
                            .clickable { onClick(it.id) }
                            .padding(12.dp).fillMaxWidth().height(350.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Box(Modifier.fillMaxSize()) {
                            AsyncImage(
                                model = it.imageUrl,
                                contentDescription = null,
                                modifier = Modifier.fillMaxWidth().height(350.dp),
                                contentScale = ContentScale.Crop
                            )

                            Box(
                                modifier = Modifier
                                    .background(
                                        color = Color.Gray,
                                        shape = RoundedCornerShape(
                                            bottomEnd = 12.dp,
                                            bottomStart = 12.dp
                                        )
                                    ).align(Alignment.BottomCenter).fillMaxWidth(),
                            ) {
                                Text(
                                    it.name, style = MaterialTheme.typography.bodySmall,
                                    maxLines = 1,
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                    overflow = TextOverflow.Ellipsis,
                                    fontSize = 18.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
