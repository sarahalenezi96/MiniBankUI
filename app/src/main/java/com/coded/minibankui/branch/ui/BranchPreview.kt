package com.coded.minibankui.branch.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.coded.minibankui.branch.model.BankBranch

@Composable
fun BranchPreview(
    branch: BankBranch,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = branch.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "📍 ${branch.location}")
            Text(text = "📞 ${branch.phone}")
        }
    }
}
