package com.example.firebase_auth.models

class User {
    var email:String=""
    var pass:String=""
    var confpass:String=""
    var userid:String=""

    constructor(email:String,pass:String,confpass:String,userid:String ){
        this.email=email
        this.pass=pass
        this.confpass=confpass
        this.userid=userid
    }


}