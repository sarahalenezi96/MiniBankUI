package com.coded.minibankui.branch.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coded.minibankui.branch.model.BankBranch
import com.coded.minibankui.branch.repository.BranchRepository

@Composable
fun BranchDetailScreen(branchName: String) {
    val branch: BankBranch? = BranchRepository.branches.find { it.name == branchName }

    if (branch == null) {
        Text(
            text = "Branch not found",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(16.dp)
        )
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Branch Name: ${branch.name}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Location: ${branch.location}",
            fontSize = 16.sp
        )
        Text(
            text = "Phone: ${branch.phone}",
            fontSize = 16.sp
        )
        Text(
            text = "Working Hours: ${branch.workingHours.open} - ${branch.workingHours.close}",
            fontSize = 16.sp
        )
    }
}
