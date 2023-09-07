package com.example.firebase_auth.ui.theme.screens.products
//
//
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.Button
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.BlendMode.Companion.Color
//
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.text.style.TextDecoration
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AddProductsScreen(controller: NavHostController) {
//
//    Column(modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally) {
//        val context = LocalContext.current
//        Text(
//            text = "Add product",
//            fontSize = 30.sp,
//            fontFamily = FontFamily.Cursive,
//            color = androidx.compose.ui.graphics.Color.Red,
//            modifier = Modifier.padding(20.dp),
//            fontWeight = FontWeight.Bold,
//            textDecoration = TextDecoration.Underline
//        )
//
//        var productName by remember { mutableStateOf(TextFieldValue("")) }
//        var productQuantity by remember { mutableStateOf(TextFieldValue("")) }
//        var productPrice by remember { mutableStateOf(TextFieldValue("")) }
//
//        OutlinedTextField(
//            value = productName,
//            onValueChange = { productName = it },
//            label = { Text(text = "Product name *") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
//        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        OutlinedTextField(
//            value = productQuantity,
//            onValueChange = { productQuantity = it },
//            label = { Text(text = "Product quantity *") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
//        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        OutlinedTextField(
//            value = productPrice,
//            onValueChange = { productPrice = it },
//            label = { Text(text = "Product price *") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
//        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Button(onClick = {
//            //-----------WRITE THE SAVE LOGIC HERE---------------//
//            val productRepository = ProductRepository(controller,context)
//            productRepository.saveProduct(productName.text.trim(),productQuantity.text.trim(),
//                productPrice.text)
//
//
//        }) {
//            Text(text = "Save")
//        }
//
//    }
//}

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebase_auth.data.ProductViewModel
import com.example.firebase_auth.models.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductsScreen(controller: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        Text(
            text = "Add product",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var productName by remember { mutableStateOf(TextFieldValue("")) }
        var productQuantity by remember { mutableStateOf(TextFieldValue("")) }
        var productPrice by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text(text = "Product name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productQuantity,
            onValueChange = { productQuantity = it },
            label = { Text(text = "Product quantity *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productPrice,
            onValueChange = { productPrice = it },
            label = { Text(text = "Product price *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            //-----------WRITE THE SAVE LOGIC HERE---------------//
            var productRepository = ProductViewModel(controller,context)
            productRepository.saveProduct(productName.text.trim(),productQuantity.text.trim(),
                productPrice.text)


        }) {
            Text(text = "Save")
        }

    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AddProductsScreenPreview() {
    
        AddProductsScreen(rememberNavController())
    
}
