package com.example.firebase_auth.ui.theme.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebase_auth.data.ProductViewModel
import com.example.firebase_auth.navigation.ROUTE_ADD_PRODUCTS
import com.example.firebase_auth.navigation.ROUTE_UPDATE_PRODUCTS
import com.example.firebase_auth.navigation.ROUTE_VIEW_PRODUCTS

@Composable
fun HomeScreen(controller: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        val context= LocalContext.current
        var productdata=ProductViewModel(controller,context)

        Text(
            text = "WELCOME :)",
            fontSize = 18.sp,
            fontFamily = FontFamily.Cursive
        )

        Button(onClick = { controller.navigate(ROUTE_ADD_PRODUCTS) }) {
            Text(text = "Add Product")

        }
        Button(onClick = { controller.navigate(ROUTE_VIEW_PRODUCTS) }) {
            Text(text = "View Product")

        }
        Button(onClick = { controller.navigate(ROUTE_UPDATE_PRODUCTS) }) {
            Text(text = "Update Product")

        }

    }

}

@Preview
@Composable
fun HomePreview() {
    HomeScreen(rememberNavController())

}