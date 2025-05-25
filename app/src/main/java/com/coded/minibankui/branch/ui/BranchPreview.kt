package com.coded.minibankui.branch.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.coded.minibankui.R
import com.coded.minibankui.branch.model.BankBranch

@Composable
fun BranchPreview(
    branch: BankBranch,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .clickable { onClick() }, // Whole card is clickable
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            AsyncImage(
                model = branch.imageUri.ifBlank { null },
                contentDescription = "Branch image",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.default_branch),
                error = painterResource(R.drawable.default_branch),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clickable { onClick() } // Image is also clickable
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = branch.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.clickable { onClick() } // name also clickable
            )
        }
    }
}
