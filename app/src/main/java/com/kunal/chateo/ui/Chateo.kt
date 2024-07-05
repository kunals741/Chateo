package com.kunal.chateo.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
object Onboarding

@Serializable
object EnterPhoneNumber

@Serializable
data class OTPScreen(
    val mobileNumber: String
)

@Composable
fun ChateoApp(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Onboarding) {
        composable<Onboarding> {
            OnboardingScreen(
                modifier,
                onStartMessagingClick = { navController.navigate(route = EnterPhoneNumber) }
            )
        }
        composable<EnterPhoneNumber> {
            EnterPhoneNumberScreen(
                modifier,
                onBackIconClick = { navController.popBackStack() },
                onContinueClick = { navController.navigate(OTPScreen(mobileNumber = it)) }
            )
        }
        composable<OTPScreen> {
            //todo
        }
    }
}