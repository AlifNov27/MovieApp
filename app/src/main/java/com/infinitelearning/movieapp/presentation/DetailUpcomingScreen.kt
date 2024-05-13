package com.infinitelearning.movieapp.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.infinitelearning.movieapp.R
import com.infinitelearning.movieapp.data.DummyData
import com.infinitelearning.movieapp.model.Upcoming

@Composable
fun DetailUpcomingScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    upcomingId: Int?
) {
    val newUpcomingList = DummyData.upcomingMovies.filter { upcoming ->
        upcoming.id == upcomingId
    }
    Column(
        modifier = modifier
    ) {
        DetailUpcomingContent(newUpcomingList = newUpcomingList)
    }
}

@Composable
private fun DetailUpcomingContent(
    newUpcomingList: List<Upcoming>,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = newUpcomingList[0].assetImage)
                    .build(),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(height = 250.dp, width = 170.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentDescription = "Poster Movie"
            )
            Spacer(modifier = Modifier.width(24.dp))
            Column {
                MovieInfo(
                    painterResourceId = R.drawable.baseline_videocam,
                    title = "Genre",
                    value = newUpcomingList[0].type
                )
                MovieInfo(
                    painterResourceId = R.drawable.baseline_access_time_filled,
                    title = "Duration",
                    value = newUpcomingList[0].duration
                )
                MovieInfo(
                    painterResourceId = R.drawable.baseline_stars,
                    title = "Rating",
                    value = newUpcomingList[0].rating
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.padding(4.dp)) {

            }
        }
        Text(
            newUpcomingList[0].title, style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(
                horizontal = 24.dp, vertical = 16.dp
            )
        )
        Text(
            "Synopsis", style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(
                horizontal = 24.dp
            )
        )
        Text(
            newUpcomingList[0].synopsis, style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(
                horizontal = 24.dp, vertical = 16.dp,
            )
        )
        Spacer(modifier = Modifier.height(64.dp))
    }
}

@Composable
fun MovieInfo(
    @DrawableRes painterResourceId: Int,
    title: String,
    value: String,
) {
    Icon(
        painter = painterResource(id = painterResourceId),
        contentDescription = title,
        modifier = Modifier.padding(vertical = 4.dp)
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(text = title, style = MaterialTheme.typography.bodySmall)
    Spacer(modifier = Modifier.height(4.dp))
    Text(text = value, style = MaterialTheme.typography.titleMedium)
}