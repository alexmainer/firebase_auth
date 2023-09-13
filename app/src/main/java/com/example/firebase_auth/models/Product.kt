package com.example.firebase_auth.models

import android.content.Context
import androidx.navigation.NavHostController

class Product {
    var name:String=""
    var quantity:String=""
    var price:String=""
    var id:String=""

    constructor(){}

    constructor(name: String, quantity: String, price:String, id:String ){
        this.name=name
        this.quantity=quantity
        this.price=price
        this.id=id
    }
}