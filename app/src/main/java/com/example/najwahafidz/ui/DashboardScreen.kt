package com.example.najwahafidz.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.navigation.NavController
import com.example.najwahafidz.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun DashboardScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {

        // 🔵 Ornamen kanan atas (hiasan dekoratif)
        Image(
            painter = painterResource(id = R.drawable.grp80), // <- ganti sesuai file ornamenmu
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(310.dp)
                .align(Alignment.TopEnd)
                .offset(x = 40.dp, y = (-80).dp)
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            // 🔠 Header
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.height(12.dp)) // Jarak antara ikon dan teks
                Text(
                    text = "Dashboard",
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 45.sp,

                    color = Color.Black
                )
            }


            Spacer(modifier = Modifier.height(70.dp))

            // 🔢 Ringkasan
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                InfoCard(title = "Total error", value = "12 Error", modifier = Modifier.weight(1f))
                InfoCard(title = "Respon Time", value = "12 Error", modifier = Modifier.weight(1f))
                InfoCard(title = "To fixed", value = "12 Error", modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(32.dp))

            // 📊 Grafik
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Error Rate", style = MaterialTheme.typography.titleMedium)
                        Row {
                            OutlinedButton(onClick = { }) { Text("Week") }
                            Spacer(modifier = Modifier.width(8.dp))
                            OutlinedButton(onClick = { }) { Text("Day") }
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .background(Color(0xFFE0E0E0), RoundedCornerShape(12.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Grafik Error (dummy)", color = Color.DarkGray)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 📋 Log List
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    itemsIndexed(List(4) { "Google Login Failed" }) { index, title ->
                        ErrorLogItem(
                            title = title,
                            date = "March 12, 2025",
                            status = "High"
                        )
                        if (index < 3) {
                            Divider(thickness = 1.dp, color = Color.Gray)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun InfoCard(title: String, value: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color(0xFFFFF0C1), RoundedCornerShape(16.dp))
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, style = MaterialTheme.typography.bodyMedium, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = value, style = MaterialTheme.typography.bodyLarge, color = Color.Black)
    }
}

@Composable
fun ErrorLogItem(title: String, date: String, status: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = title, style = MaterialTheme.typography.bodyMedium)
            Text(text = date, style = MaterialTheme.typography.bodySmall)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "🔴 $status",
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.width(12.dp))
            Row {
                Icon(Icons.Default.Search, contentDescription = "view", modifier = Modifier.size(16.dp))
                Text(
                    text = "view",
                    modifier = Modifier.padding(start = 4.dp),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
