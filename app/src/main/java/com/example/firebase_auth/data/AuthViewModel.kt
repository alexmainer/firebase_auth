package com.example.firebase_auth.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.firebase_auth.models.User
import com.example.firebase_auth.navigation.ROUTE_HOME
import com.example.firebase_auth.navigation.ROUTE_LOGIN
import com.example.firebase_auth.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel(var controller:NavHostController,var context:Context) {

    var mAuth:FirebaseAuth
    val progress:ProgressDialog

    init {
        mAuth=FirebaseAuth.getInstance()
        progress=ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please Wait.....")

    }
    fun signup(email:String,pass:String,confpass:String){
//        progress.show()


        if (email.isBlank() || pass.isBlank() || confpass.isBlank()){
            Toast.makeText(context,"Please fill the blanks",Toast.LENGTH_LONG).show()
            return

        }
        else if (pass != confpass){
            Toast.makeText(context,"Password do not match",Toast.LENGTH_LONG).show()
            return
        }
        else{
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                if (it.isSuccessful){
                    val userdata=User(email,pass,mAuth.currentUser!!.uid)
                    val regRef=FirebaseDatabase.getInstance().getReference().child("Users/"+mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener {


                        if (it.isSuccessful) {
                            Toast.makeText(
                                context,
                                "Account Created Successfully",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG)
                                .show()
                        }
                    }

            }
        }
        }


    }
 
    fun login(email: String,pass: String){
//        progress.show()

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