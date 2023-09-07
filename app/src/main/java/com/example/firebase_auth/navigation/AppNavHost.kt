package com.example.firebase_auth.navigation

//import AddProductsScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebase_auth.ui.theme.screens.about.AboutScreen
import com.example.firebase_auth.ui.theme.screens.home.HomeScreen
import com.example.firebase_auth.ui.theme.screens.login.LoginScreen
import com.example.firebase_auth.ui.theme.screens.products.AddProductsScreen
import com.example.firebase_auth.ui.theme.screens.products.UpdateProductsScreen
import com.example.firebase_auth.ui.theme.screens.products.ViewProductsScreen
import com.example.firebase_auth.ui.theme.screens.register.RegisterPreview
import com.example.firebase_auth.ui.theme.screens.register.RegisterScreen

@Composable
fun AppNavHost(modifier: Modifier=Modifier,controller:NavHostController= rememberNavController(),startDestination:String= ROUTE_HOME) {

    NavHost(navController = controller, modifier=Modifier, startDestination=startDestination){
        composable(ROUTE_LOGIN){
            LoginScreen(controller)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(controller)
        }
        composable(ROUTE_ABOUT){
            AboutScreen(controller)
        }
        composable(ROUTE_HOME){
            HomeScreen(controller)
        }
        composable(ROUTE_ADD_PRODUCTS){
            AddProductsScreen(controller)
        }
        composable(ROUTE_VIEW_PRODUCTS){
            ViewProductsScreen(controller)
        }
        composable(ROUTE_UPDATE_PRODUCTS+"/{id}"){passedData->
            UpdateProductsScreen(controller,passedData.arguments?.getString("id")!!)
        }


    }



}











