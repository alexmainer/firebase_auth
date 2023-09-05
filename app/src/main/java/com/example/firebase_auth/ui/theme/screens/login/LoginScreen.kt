package com.example.firebase_auth.ui.theme.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebase_auth.data.AuthViewModel
import com.example.firebase_auth.navigation.ROUTE_REGISTER

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(controller:NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    val context= LocalContext.current
    Column (
        modifier= Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = "LogIn Here!",
            color = Color.Cyan,
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

        Button(onClick = {
            val mylogin=AuthViewModel(controller,context)
            mylogin.login(email.text.trim(),pass.text.trim())
                         }
            ,modifier = Modifier.fillMaxWidth())
        {
            Text(text = "LogIn")


        }

        Spacer(modifier= Modifier.height(19.dp))

        Button(onClick = { controller.navigate(ROUTE_REGISTER) },modifier = Modifier.fillMaxWidth())
        {
            Text(text = "Don't have an account? Click to register")


        }

    }

}
@Preview
@Composable
fun LogInPreview() {
    LoginScreen(rememberNavController())

}
