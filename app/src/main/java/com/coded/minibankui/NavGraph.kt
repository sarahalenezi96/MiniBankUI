package com.coded.minibankui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coded.minibankui.branch.model.BankBranch
import com.coded.minibankui.branch.ui.BranchDetailScreen
import com.coded.minibankui.branch.ui.BranchListScreen
import com.coded.minibankui.branch.viewmodel.BranchViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel: BranchViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "branchList",
        modifier = modifier
    ) {
        composable("branchList") {
            BranchListScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable("branchDetail") {
            val branch = navController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<BankBranch>("branch")

            if (branch != null) {
                BranchDetailScreen(
                    branch = branch,
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }
    }
}