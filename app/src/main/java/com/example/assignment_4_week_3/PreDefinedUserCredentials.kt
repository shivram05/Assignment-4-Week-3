package com.example.assignment_4_week_3

object PreDefinedUserCredentials {

    val data = HashMap<String,String>()
    fun userCredentialsData() : HashMap<String,String>{
        data["shivram"] = "shivram123"
        data["test"] = "test123"
        return data
    }
}