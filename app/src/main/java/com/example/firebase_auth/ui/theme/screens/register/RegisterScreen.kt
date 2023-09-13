package com.example.firebase_auth.ui.theme.screens.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebase_auth.data.AuthViewModel
import com.example.firebase_auth.navigation.ROUTE_LOGIN
import com.example.firebase_auth.navigation.ROUTE_REGISTER

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(controller:NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confpass by remember { mutableStateOf(TextFieldValue("")) }
    val context= LocalContext.current
    Column (
        modifier= Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,

    )
    {
        Text(
            text = "Register",
            color = Color(0xFFFF9800),
            fontFamily = FontFamily.Cursive,
            fontSize = 40.sp
        )

        Spacer(modifier= Modifier.height(19.dp))

        OutlinedTextField(
            value = email ,
            label = { Text(text = "Enter Email Address")},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onValueChange = {
                email=it
            }
        )

        Spacer(modifier= Modifier.height(19.dp))

        OutlinedTextField(
            value = pass ,
            label = { Text(text = "Enter Password")},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onValueChange = {
                pass=it
            }
        )

        Spacer(modifier= Modifier.height(19.dp))

        OutlinedTextField(
            value = confpass ,
            label = { Text(text = "Confirm Password")},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onValueChange = {
                confpass=it
            }
        )

        Spacer(modifier= Modifier.height(19.dp))

        Button(onClick = {
            val myregister=AuthViewModel(controller,context)
            myregister.signup(email.text.trim(),pass.text.trim(), confpass.text.trim())
                         }
            ,colors = ButtonDefaults.buttonColors(Color.Black),)
        {
            Text(text = "Register")


        }

        Spacer(modifier= Modifier.height(19.dp))

        Button(onClick = {
            controller.navigate(ROUTE_LOGIN)
                         },
            modifier = Modifier.fillMaxWidth(),
            border = BorderStroke(0.dp, Color.Transparent), // Remove the border
            colors = ButtonDefaults.buttonColors(Color.White)
        )
        {
            Text(
                text = "Already have an account? Click to LogIn",
                color = Color(0xFFFF9800),)


        }

    }

}
@Preview
@Composable
fun RegisterPreview() {
    RegisterScreen(rememberNavController())

}
