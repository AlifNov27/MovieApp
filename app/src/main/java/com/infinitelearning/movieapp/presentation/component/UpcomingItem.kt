package com.infinitelearning.movieapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.infinitelearning.movieapp.model.Upcoming

@Composable
fun UpcomingItem(
    upcoming: Upcoming,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable {
            onItemClicked(upcoming.id)
        }
    ) {
//        Image(
//            painter = painterResource(id = upcoming.assetImage),
//            contentDescription = "Movie Image",
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .fillMaxWidth(fraction = 0.85f)
//                .height(340.dp)
//        )
//        Box(
//            modifier = Modifier
//                .fillMaxWidth(fraction = 0.85f)
//                .wrapContentHeight()
//                .background(
//                    Color.Blue
//                )
//                .padding(vertical = 16.dp),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(
//                "Movie Detail", style = MaterialTheme.typography.titleMedium.copy(
//                    color = Color.Yellow,
//                    fontWeight = FontWeight.Bold
//                )
//            )
        Image(
            painter = painterResource(id = upcoming.assetImage),
            contentDescription = upcoming.title, modifier = Modifier
                .clip(RoundedCornerShape(90.dp))
                .size(150.dp)
        )
        Text(
            text = upcoming.title,
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )
        Text(
            text = upcoming.type,
            color = MaterialTheme.colorScheme.primary,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )
        }
}
