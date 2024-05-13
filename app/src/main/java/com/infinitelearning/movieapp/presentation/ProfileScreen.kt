package com.infinitelearning.movieapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.infinitelearning.movieapp.R

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Column {
        Image(
            painter = painterResource(R.drawable.alifnov),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(horizontal = 24.dp, vertical = 8.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Text(text = "Nama: Alif Novika Sari",
            modifier = Modifier.padding(
                horizontal = 24.dp, vertical = 8.dp))
        Text(text = "Email: 123210007@student.upnyk.ac.id",
            modifier = Modifier.padding(
                horizontal = 24.dp, vertical = 8.dp))
        Text(text = "Asal PT: Universitas Pembangunan Nasional \"Veteran\" Yogyakarta",
            modifier = Modifier.padding(
                horizontal = 24.dp, vertical = 8.dp))
        Text(text = "Jurusan: Informatika",
            modifier = Modifier.padding(
                horizontal = 24.dp, vertical = 8.dp))
    }
}