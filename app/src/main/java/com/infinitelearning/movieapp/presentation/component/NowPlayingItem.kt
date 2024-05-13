package com.infinitelearning.movieapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.infinitelearning.movieapp.model.NowPlaying

@Composable
fun NowPlayingItem(
    nowplaying: NowPlaying,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onItemClicked(nowplaying.id)
            }
    ) {
        Image(
            painter = painterResource(id = nowplaying.assetImage),
            contentDescription = nowplaying.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .size(100.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Column {
            Text(text = nowplaying.title, style = MaterialTheme.typography.titleMedium)
            Row {
                Text(text = nowplaying.duration, color = MaterialTheme.colorScheme.primary)
                Text(text = " - ${nowplaying.type}")
            }
        }
    }
}

