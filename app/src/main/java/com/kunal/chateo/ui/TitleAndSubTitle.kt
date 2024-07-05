package com.kunal.chateo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kunal.chateo.ui.theme.OffWhite

@Composable
fun TitleAndSubTitle(modifier: Modifier, title: String?, subTitle: String?) {
    Column(modifier = modifier) {
        if (title != null) {
            Text(
                text = title,
                style = MaterialTheme.typography.displayMedium,
                color = OffWhite
            )
        }
        if (subTitle != null) {
            Text(
                text = subTitle,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                color = OffWhite,
                modifier = Modifier.padding(top = 8.dp, start = 40.dp, end = 40.dp)
            )
        }
    }
}