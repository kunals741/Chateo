package com.kunal.chateo.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kunal.chateo.R
import com.kunal.chateo.ui.theme.BlueColor
import com.kunal.chateo.ui.theme.OffWhite

@Composable
fun OnboardingScreen(modifier: Modifier, onStartMessagingClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.onboarding_image),
            contentDescription = stringResource(R.string.onboarding_image),
            modifier = Modifier.padding(top = 102.dp)
        )

        Text(
            text = stringResource(R.string.onboarding_text),
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
            color = OffWhite,
            modifier = Modifier.padding(top = 42.dp, start = 48.dp, end = 48.dp)
        )

        Spacer(
            Modifier.weight(1f)
        )

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = BlueColor
            ),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 32.dp),
            onClick = { onStartMessagingClick() }
        ) {
            Text(
                stringResource(R.string.start_messaging).uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = OffWhite,
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "id:pixel_8",
    uiMode = Configuration.UI_MODE_NIGHT_MASK,
)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(Modifier, {})
}