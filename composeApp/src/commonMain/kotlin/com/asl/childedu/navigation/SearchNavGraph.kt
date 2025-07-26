package com.asl.childedu.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.asl.search.ui.SearchScreen

object SearchNavGraph : BaseNavGraph {

    sealed class Dest(val route: String) {
        data object Root : Dest("/search-root")
        data object Search : Dest("/search")
    }

    override fun build(
        modifier: Modifier,
        navHostController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            startDestination = Dest.Search.route,
            route = Dest.Root.route
        ) {
            composable(route = Dest.Search.route) {
                SearchScreen(
                    onClick = {
                        navHostController.navigate(
                            GameNavGraph.Dest.Details.getRoute(it)
                        )
                    },
                    modifier = Modifier.fillMaxSize(),
                    onBackClick = {
                        navHostController.popBackStack()
                    }
                )
            }
        }
    }
}