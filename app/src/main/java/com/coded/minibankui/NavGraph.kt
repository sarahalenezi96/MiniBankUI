package com.coded.minibankui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.coded.minibankui.branch.model.BankBranch
import com.coded.minibankui.branch.ui.BranchDetailScreen
import com.coded.minibankui.branch.ui.BranchListScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "branchList",
        modifier = modifier
    ) {
        composable("branchList") {
            BranchListScreen(
                navController = navController,
                onBranchClick = { branch ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("branch", branch)
                    navController.navigate("branchDetail")
                }
            )
        }

        composable("branchDetail") {
            val branch = navController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<BankBranch>("branch")

            if (branch != null) {
                BranchDetailScreen(branch = branch, navController = navController)
            }
        }
    }
}