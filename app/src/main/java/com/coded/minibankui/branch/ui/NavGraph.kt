package com.coded.minibankui.branch.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.coded.minibankui.branch.ui.BranchListScreen

@Composable
fun BranchNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "branchList"
    ) {
        composable("branchList") {
            BranchListScreen()
        }
    }
}
