package com.coded.minibankui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.coded.minibankui.branch.ui.BranchDetailScreen
import com.coded.minibankui.branch.ui.BranchListScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "branches") {
        composable(route = "branches") {
            BranchListScreen(
                navController = navController,
                onBranchClick = { branch ->
                    navController.navigate("branch_detail/${branch.name}")
                }
            )
        }
        composable(
            route = "branch_detail/{branchName}",
            arguments = listOf(navArgument("branchName") { type = NavType.StringType })
        ) { backStackEntry ->
            val branchName = backStackEntry.arguments?.getString("branchName") ?: ""
            BranchDetailScreen(branchName = branchName, navController = navController)

        }
    }
}
