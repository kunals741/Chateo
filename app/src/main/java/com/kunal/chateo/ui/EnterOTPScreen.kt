package com.kunal.chateo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kunal.chateo.R
import com.kunal.chateo.ui.components.OtpInputField
import com.kunal.chateo.ui.theme.BlueColor
import com.kunal.chateo.ui.theme.OffWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterOTPScreen(
    modifier: Modifier,
    mobileNumber: String,
    onBackIconClick: () -> Unit,
    onVerifyOtpClick: () -> Unit
) {
    var enteredOTP by rememberSaveable { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    var isOtpFilled by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    Image(
        painter = painterResource(R.drawable.ic_back),
        contentDescription = stringResource(R.string.back_icon),
        modifier = modifier
            .padding(top = 16.dp, start = 16.dp)
            .clickable { onBackIconClick() }
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 100.dp)
    ) {

        Text(
            text = stringResource(R.string.enter_otp),
            style = MaterialTheme.typography.displayMedium,
            color = OffWhite
        )
        Text(
            text = stringResource(R.string.we_have_sent_you_an_sms_with_the_code_to, mobileNumber),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            color = OffWhite,
            modifier = Modifier.padding(top = 8.dp, start = 58.dp, end = 56.dp)
        )
        OtpInputField(
            modifier = Modifier
                .padding(top = 48.dp)
                .focusRequester(focusRequester),
            otpText = enteredOTP,
            shouldShowCursor = true,
            shouldCursorBlink = true,
            onOtpModified = { value, otpFilled ->
                enteredOTP = value
                isOtpFilled = otpFilled
                if (otpFilled) {
                    keyboardController?.hide()
                }
            }
        )

        Spacer(
            Modifier.weight(1f)
        )

        Text(
            stringResource(R.string.resend_code),
            style = MaterialTheme.typography.headlineMedium,
            color = OffWhite,
            modifier = Modifier
                .padding(bottom = 18.dp)
                .clickable {
                    //todo resend otp
                }
        )

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = BlueColor
            ),
            enabled = (isOtpFilled),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 32.dp),
            onClick = { onVerifyOtpClick() }
        ) {
            Text(
                stringResource(R.string.verify).uppercase(),
                style = MaterialTheme.typography.headlineMedium,
                color = OffWhite,
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }
    }
}