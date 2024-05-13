package com.infinitelearning.movieapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.infinitelearning.movieapp.data.DummyData
import com.infinitelearning.movieapp.model.NowPlaying
import com.infinitelearning.movieapp.model.Upcoming
import com.infinitelearning.movieapp.navigation.Screen
import com.infinitelearning.movieapp.presentation.component.NowPlayingItem
import com.infinitelearning.movieapp.presentation.component.UpcomingItem

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    upcomingmovies: List<Upcoming> = DummyData.upcomingMovies,
    now_playingmovies: List<NowPlaying> = DummyData.nowPlayingMovies,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier

    ) {
        item {

            Text(
                text = "Upcoming Movie",
                style = typography.headlineSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = modifier
            ) {
                items(upcomingmovies, key = { it.id }) {
                    UpcomingItem(upcoming = it) { upcomingId ->
                        navController.navigate(Screen.Detail.route + "u/$upcomingId")
                    }
                }
            }
            Text(
                text = "Now Playing Movie",
                style = typography.headlineSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
        items(now_playingmovies, key = { it.id }) {
            NowPlayingItem(nowplaying = it) { nowPlayingId ->
                navController.navigate(Screen.Detail.route + "n/$nowPlayingId")
            }
        }
    }
}