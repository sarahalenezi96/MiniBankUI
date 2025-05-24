package com.coded.minibankui.branch.ui

import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.coded.minibankui.branch.model.BankBranch
import com.coded.minibankui.branch.viewModel.BranchViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController



@Composable
fun BranchListScreen(
    navController: NavHostController,
    viewModel: BranchViewModel = viewModel(),
    onBranchClick: (BankBranch) -> Unit
) {
    val branches = viewModel.branches

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = "Bank Branches",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(branches) { branch ->
                BranchPreview(branch = branch, onClick = { onBranchClick(branch) })
            }
        }
    }
}
