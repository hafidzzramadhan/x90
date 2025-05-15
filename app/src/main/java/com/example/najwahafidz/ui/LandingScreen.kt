package com.example.najwahafidz.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.najwahafidz.R
import androidx.compose.ui.text.font.FontWeight

@Composable
fun LandingScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {

        // 🔶 Ornamen kiri atas
        Image(
            painter = painterResource(id = R.drawable.grp_79),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.TopStart)
                .offset(x = (-20).dp, y = (-20).dp)
        )

        // 🔵 Ornamen kanan bawah
        Image(
            painter = painterResource(id = R.drawable.grp_78),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(320.dp)
                .align(Alignment.BottomEnd)
                .offset(x = 20.dp, y = 20.dp)
        )

        // 🧱 Card berisi konten utama
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .align(Alignment.Center), // Posisi card di tengah layar
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(42.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Sistem\nImplementasi",
                    fontSize = 37.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 28.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Aplikasi ini digunakan untuk mengelola implementasi dan pemeliharaan perangkat lunak. Adapun salah satu kemampuan aplikasi ini sebagai berikut:\n\n" +
                            "- Merekam aktivitas implementasi perangkat lunak\n\n" +
                            "- Merekam data transaksi model baik fitur input maupun label output",
                    fontSize = 14.sp,
                    color = Color.Black,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(70.dp))

                Button(
                    onClick = {
                        navController.navigate("login") {
                            popUpTo("landing") { inclusive = true }
                        }
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Get started", color = Color.White)
                }
            }
        }
    }
}
