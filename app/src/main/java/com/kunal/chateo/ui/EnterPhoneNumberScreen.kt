package com.kunal.chateo.ui

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.kunal.chateo.R
import com.kunal.chateo.ui.theme.BlueColor
import com.kunal.chateo.ui.theme.DarkBlue
import com.kunal.chateo.ui.theme.OffWhite
import com.kunal.chateo.ui.theme.mulishFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun EnterPhoneNumberScreen(modifier: Modifier) {
    var enteredPhoneNumber by rememberSaveable { mutableStateOf("") }
    val enabled by remember { mutableStateOf(true) }
    val interactionSource = remember { MutableInteractionSource() }


    val selectedCountryCode by rememberSaveable { mutableStateOf("\uD83C\uDDEE\uD83C\uDDF3 +91") }

    Image(
        painter = painterResource(R.drawable.ic_back),
        contentDescription = stringResource(R.string.back_icon),
        modifier = modifier.padding(top = 16.dp, start = 16.dp)
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
    ) {

        Text(
            text = stringResource(R.string.enter_your_phone_number),
            style = MaterialTheme.typography.displayMedium,
            color = OffWhite
        )
        Text(
            text = stringResource(R.string.confirm_phone_number),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            color = OffWhite,
            modifier = Modifier.padding(top = 8.dp, start = 40.dp, end = 40.dp)
        )
        Row(
            modifier = Modifier.padding(top = 48.dp, start = 24.dp, end = 24.dp)
        ) {
            Text(
                text = selectedCountryCode,
                color = OffWhite,
                fontFamily = mulishFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                modifier = Modifier
                    .background(DarkBlue)
                    .padding(vertical = 6.dp, horizontal = 8.dp)
            )

            BasicTextField(
                value = enteredPhoneNumber,
                onValueChange = {
                    if (it.isDigitsOnly() && it.length <= 10) {
                        enteredPhoneNumber = it
                    }
                },
                enabled = enabled,
                singleLine = true,
                interactionSource = interactionSource,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
                    .background(
                        color = DarkBlue,
                        shape = RoundedCornerShape(4.dp)
                    ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(
                    color = OffWhite,
                    fontFamily = mulishFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                ),
                decorationBox = @Composable { innerTextField ->
                    TextFieldDefaults.DecorationBox(
                        value = enteredPhoneNumber,
                        innerTextField = innerTextField,
                        enabled = enabled,
                        singleLine = true,
                        visualTransformation = VisualTransformation.None,
                        interactionSource = interactionSource,
                        placeholder = {
                            Text(
                                "Phone Number",
                                style = MaterialTheme.typography.bodyLarge,
                                color = OffWhite
                            )
                        },
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
                        container = {
                            RoundedCornerShape(4.dp)
                        },
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = DarkBlue,
                            focusedContainerColor = DarkBlue,
                            focusedTextColor = OffWhite,
                            unfocusedTextColor = OffWhite,
                            unfocusedPlaceholderColor = OffWhite,
                            cursorColor = OffWhite
                        )
                    )
                }
            )
        }
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
            onClick = {//todo
            }
        ) {
            Text(
                stringResource(R.string.continue_btn).uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = OffWhite,
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }
    }
}


@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EnterPhoneNumberScreenPreview() {
    EnterPhoneNumberScreen(Modifier)
}