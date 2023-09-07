package com.example.firebase_auth.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.firebase_auth.navigation.ROUTE_HOME
import com.example.firebase_auth.navigation.ROUTE_LOGIN
import com.example.firebase_auth.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel(var controller:NavHostController,var context:Context) {

    var mAuth:FirebaseAuth

    init {
        mAuth=FirebaseAuth.getInstance()
    }
    fun signup(email:String,pass:String,confpass:String){


        if (email.isBlank() || pass.isBlank() || confpass.isBlank()){
            Toast.makeText(context,"Please fill the blanks",Toast.LENGTH_LONG).show()
            return

        }
        else if (pass != confpass){
            Toast.makeText(context,"Password do not match",Toast.LENGTH_LONG).show()
            return
        }
        else{
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(context,"Account Created Successfully",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                }

            }
        }


    }

    fun login(email: String,pass: String){
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(context,"LogIn successful",Toast.LENGTH_LONG).show()
                controller.navigate(ROUTE_HOME)
            }
            else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                controller.navigate(ROUTE_LOGIN)
            }
        }
    }

    fun logout(){
        mAuth.signOut()
        controller.navigate(ROUTE_LOGIN)
    }
    fun loggedin():Boolean{
        return mAuth.currentUser !=null
    }






}