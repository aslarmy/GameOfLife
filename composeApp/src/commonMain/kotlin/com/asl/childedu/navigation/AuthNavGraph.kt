package com.asl.childedu.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.asl.auth.ui.auth.AccountCreateConfirmScreen
import com.asl.auth.ui.auth.AuthScreen
import com.asl.auth.ui.auth.CreateAvatarScreen
import com.asl.auth.ui.auth.LoginScreenContent
import com.asl.auth.ui.auth.ProfileCreateScreen
import com.asl.auth.ui.auth.SignUpScreenContent

object AuthNavGraph : BaseNavGraph {

    sealed class Dest(val route: String) {
        data object Root : Dest("/auth-root")
        data object Auth : Dest("/auth")

        data object Login : Dest("/login")
        data object AccountCreateConfirm : Dest("/account-create-confirm")
        data object SignUp : Dest("/sign-up")
        data object Google : Dest("/google")

        data object ProfileCreateScreen : Dest("/profile-creation-screen")
        data object AvatarCreateScreen : Dest("/avatar-create-screen")
    }

    override fun build(
        modifier: Modifier,
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            route = Dest.Root.route,
            startDestination = Dest.Auth.route
        ) {
            composable(route = Dest.Auth.route) {
                AuthScreen(
                    modifier = Modifier.fillMaxSize(),
                    onClickLoginScreen = {
                        navHostController.navigate(Dest.Login.route)
                    },
                    onClickSignUpScreen = {
                        navHostController.navigate(Dest.SignUp.route)
                    },
                    onClickGoogleScreen = {
                    }
                )
            }
            composable(route = Dest.Login.route) {
                LoginScreenContent(
                    modifier = Modifier.fillMaxSize(),
                    onClickLoginBtn = {
                        navHostController.navigate(Dest.AccountCreateConfirm.route)
                    },
                    onClickSignUpScreen = {
                        navHostController.navigate(Dest.SignUp.route)
                    },
                    onClickGoogleScreen = {}
                )
            }
            composable(route = Dest.SignUp.route) {
                SignUpScreenContent(
                    modifier = Modifier.fillMaxSize(),
                    onClickSignUpBtn = {
                        navHostController.navigate(Dest.Login.route)
                    },
                    onClickLoginScreen = {
                        navHostController.navigate(Dest.Login.route)
                    }
                )
            }
            composable(route = Dest.AccountCreateConfirm.route) {
                AccountCreateConfirmScreen(
                    modifier = Modifier.fillMaxSize(),
                    onClickProfileScreen = {
                        navHostController.navigate(Dest.ProfileCreateScreen.route)
                    })
            }

            composable(route = Dest.ProfileCreateScreen.route) {
                ProfileCreateScreen(
                    modifier = Modifier.fillMaxSize(),
                    onClickAvatarCreateScreen = {
                        navHostController.navigate(Dest.AvatarCreateScreen.route)
                    }
                )
            }

            composable(route = Dest.AvatarCreateScreen.route) {
                CreateAvatarScreen(
                    modifier = Modifier.fillMaxSize(),
                    onClickMainScreen = {},
                    onBackClick = {
                        navHostController.popBackStack()
                    }
                )
            }
        }
    }

}