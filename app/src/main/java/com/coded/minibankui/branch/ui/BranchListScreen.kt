package com.coded.minibankui.branch.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.coded.minibankui.branch.model.BankBranch

@Composable
fun BranchListScreen(
    branches: List<BankBranch>,
    onBranchClick: (BankBranch) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(branches) { branch ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onBranchClick(branch) }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = branch.name, style = MaterialTheme.typography.titleMedium)
                    Text(text = branch.location, style = MaterialTheme.typography.bodyMedium)
                    Text(text = branch.phone, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}