package com.coded.minibankui.branch.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.coded.minibankui.branch.model.BankBranch
import com.coded.minibankui.branch.viewModel.BranchViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coded.minibankui.branch.ui.BranchPreview


@Composable
fun BranchListScreen(
    viewModel: BranchViewModel = viewModel(),
    onBranchClick: (BankBranch) -> Unit
) {
    val branches = viewModel.branches

    LazyColumn {
        items(branches) { branch ->
            BranchPreview(branch = branch, onClick = { onBranchClick(branch) })
        }
    }
}