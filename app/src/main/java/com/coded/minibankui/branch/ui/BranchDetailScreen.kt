package com.coded.minibankui.branch.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.coded.minibankui.R
import com.coded.minibankui.branch.model.BankBranch

@Composable
fun BranchDetailScreen(branch: BankBranch, navController: NavHostController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF041938), Color(0xFF233542))
                )
            )
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back",
            tint = Color.White,
            modifier = Modifier
                .padding(16.dp)
                .clickable { navController.popBackStack() }
        )

        Text(
            text = "Branch Details",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp, bottom = 11.dp)
        )

        AsyncImage(
            model = branch.imageUri.ifBlank { null },
            contentDescription = "Branch Image",
            placeholder = painterResource(R.drawable.default_branch),
            error = painterResource(R.drawable.default_branch),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(16.dp))
                .shadow(6.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White, shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "${branch.name} Branch",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1B3358)
            )

            Spacer(modifier = Modifier.height(2.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.address),
                    contentDescription = "Address icon",
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Address: ${branch.address}",
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.phone),
                    contentDescription = "Phone icon",
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = branch.phone,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.clickable {
                        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${branch.phone}"))
                        context.startActivity(dialIntent)
                    }
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.working_hours),
                    contentDescription = "Working hours icon",
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Working Hours: ${branch.workingHours.open} - ${branch.workingHours.close}",
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(branch.location))
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(220.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFF041938), Color(0xFF5C89B4))
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Text(
                    text = "Open in Google Maps",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}