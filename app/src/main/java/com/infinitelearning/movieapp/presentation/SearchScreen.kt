package com.infinitelearning.movieapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.infinitelearning.movieapp.data.DummyData
import com.infinitelearning.movieapp.model.Search
import com.infinitelearning.movieapp.navigation.Screen

@Composable
fun SearchScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    galleries: List<Search> = DummyData.movieAppSearch
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(160.dp),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(galleries, key = { it.id }) {
            Image(
                painter = painterResource(id = it.assetImage),
                contentDescription = it.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clickable {
                        navController.navigate(Screen.Detail.route + "/${it.id}")
                    }
            )
        }
    }
}
