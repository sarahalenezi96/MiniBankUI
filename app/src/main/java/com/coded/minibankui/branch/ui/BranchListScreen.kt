package com.coded.minibankui.branch.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.coded.minibankui.R
import com.coded.minibankui.branch.model.BankBranch
import com.coded.minibankui.branch.viewmodel.BranchViewModel
import androidx.compose.foundation.text.BasicTextField

@Composable
fun BranchListScreen(
    navController: NavHostController,
    viewModel: BranchViewModel = viewModel(),
    onBranchClick: (BankBranch) -> Unit = {
        navController.currentBackStackEntry?.savedStateHandle?.set("branch", it)
        navController.navigate("branchDetail")
    }
) {
    val allBranches = viewModel.branches
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    var sortAscending by remember { mutableStateOf(true) }
    var selectedTimeFilter by remember { mutableStateOf("All") }
    var expanded by remember { mutableStateOf(false) }

    val filteredList = allBranches.filter {
        val matchesSearch = it.name.contains(searchQuery.text, true) || it.address.contains(searchQuery.text, true)

        val opening = it.workingHours.open
        val matchesTime = when (selectedTimeFilter) {
            "7:00–8:00" -> opening in listOf("7:00 AM", "7:30 AM")
            "8:00–9:00" -> opening in listOf("8:00 AM", "8:30 AM")
            "9:00–10:00" -> opening == "9:00 AM"
            else -> true
        }

        matchesSearch && matchesTime
    }

    val sortedList = if (sortAscending) {
        filteredList.sortedBy { it.name }
    } else {
        filteredList.sortedByDescending { it.name }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = listOf(Color(0xFF041938), Color(0xFF233542))))
            .padding(16.dp)
    ) {
        Text(
            text = "Bank Branches",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 12.dp, top = 32.dp, bottom = 12.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFF041938))
                .padding(horizontal = 12.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                textStyle = TextStyle(color = Color.LightGray, fontSize = 14.sp),
                modifier = Modifier.fillMaxSize(),
                singleLine = true
            )
            if (searchQuery.text.isEmpty()) {
                Text("Search branches...", color = Color.Gray, fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    sortAscending = !sortAscending
                    searchQuery = TextFieldValue("")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF041938)),
                shape = RoundedCornerShape(12.dp),
                elevation = ButtonDefaults.buttonElevation(6.dp)
            ) {
                Text(
                    text = if (sortAscending) "Sort: A-Z" else "Sort: Z-A",
                    color = Color.Gray
                )
            }

            Box {
                Button(
                    onClick = { expanded = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF041938)),
                    shape = RoundedCornerShape(12.dp),
                    elevation = ButtonDefaults.buttonElevation(6.dp)
                ) {
                    Text(text = selectedTimeFilter, color = Color.Gray)
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_drop_down),
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(Color(0xFF041938))
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    listOf("All", "7:00–8:00", "8:00–9:00", "9:00–10:00").forEach { label ->
                        DropdownMenuItem(
                            text = { Text(label, color = Color.Gray) },
                            onClick = {
                                selectedTimeFilter = label
                                expanded = false
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(sortedList) { branch ->
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

                        Box(
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
                                Column {
                                    Text(
                                        text = "${branch.name} Branch",
                                        color = Color.Red,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = branch.address,
                                        color = Color.Black,
                                        fontSize = 14.sp
                                    )
                                }

                                Image(
                                    painter = painterResource(id = favIcon),
                                    contentDescription = "Favorite icon",
                                    modifier = Modifier
                                        .size(20.dp)
                                        .clickable { viewModel.toggleFavorite(branch) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}