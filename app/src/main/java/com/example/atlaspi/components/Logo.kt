package com.example.atlaspi.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale.Companion.FillWidth
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.atlaspi.R

@Composable
fun Logo( height: Int, width: Int, padding : Int

) {
    Image(
        painter = painterResource(R.drawable.atlas_logo_melhor),
        contentDescription = "Logo",
        contentScale = FillWidth,

        modifier = Modifier
            .height(height.dp)
            .width(width.dp)
            .padding(end = padding.dp)


    )

}