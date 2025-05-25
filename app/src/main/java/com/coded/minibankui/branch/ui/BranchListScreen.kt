package com.coded.minibankui.branch.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.coded.minibankui.R
import com.coded.minibankui.branch.model.BankBranch
import com.coded.minibankui.branch.repository.BranchRepository
import com.coded.minibankui.branch.viewmodel.BranchViewModel

@Composable
fun BranchListScreen(
    navController: NavHostController,
    viewModel: BranchViewModel = viewModel(),
    onBranchClick: (BankBranch) -> Unit = {
        navController.currentBackStackEntry?.savedStateHandle?.set("branch", it)
        navController.navigate("branchDetail")
    }
) {
    val branches = BranchRepository.branches

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF041938), Color(0xFF233542))
                )
            )
            .padding(16.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Bank Branches",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp, bottom = 12.dp, start = 12.dp)
                )
            }

            items(branches) { branch ->
                val isFavorite = viewModel.isFavorite(branch)
                val backgroundColor = if (isFavorite) Color(0xFF95B1C9) else Color.White
                val favIcon = if (isFavorite) R.drawable.fav else R.drawable.unfav

                Card(
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onBranchClick(branch) }
                ) {
                    Column {
                        AsyncImage(
                            model = branch.imageUri.ifBlank { null },
                            contentDescription = "Branch image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp),
                            contentScale = ContentScale.Crop,
                            placeholder = painterResource(R.drawable.default_branch),
                            error = painterResource(R.drawable.default_branch)
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(backgroundColor)
                                .padding(12.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "${branch.name} Branch",
                                    color = Color.Red,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                                Image(
                                    painter = painterResource(id = favIcon),
                                    contentDescription = "Favorite icon",
                                    modifier = Modifier
                                        .size(20.dp)
                                        .clickable { viewModel.toggleFavorite(branch) }
                                )
                            }

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = branch.address,
                                color = Color.Black,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }
        }
    }
}