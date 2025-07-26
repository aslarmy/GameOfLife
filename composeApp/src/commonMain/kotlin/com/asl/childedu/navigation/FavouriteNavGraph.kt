package com.asl.childedu.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.asl.favourite.ui.FavouriteScreen

object FavouriteNavGraph : BaseNavGraph {

    sealed class Dest(val route: String) {
        data object Root : Dest("/favourite_root")
        data object Favourite : Dest("/favourite")
    }

    override fun build(
        modifier: Modifier,
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            route = Dest.Root.route,
            startDestination = Dest.Favourite.route
        ) {
            composable(route = Dest.Favourite.route) {
                FavouriteScreen(
                    modifier = modifier.fillMaxSize(),
                    onBackClick = {
                        navHostController.popBackStack()
                    },
                    onDetails = {
                        navHostController.navigate(GameNavGraph.Dest.Details.getRoute(it))
                    }
                )
            }
        }
    }

}