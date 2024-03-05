package com.example.assignment_4_week_3

object  ValidationCheck {
    fun signupValidation(name:String, email :String, password : String, reEnterPassword: String) : String{

        if (name.isEmpty()){
            return "Name Field is empty"
        }else if (email.isEmpty()){
            return "Email Field is empty"
        }else if (password.isEmpty()){
            return "Password Field is empty"
        }else if (reEnterPassword.isEmpty()){
            return "Re-enter Password Field is empty"
        }
        return "pass"
    }

    fun passwordValidation(password: String, reEnterPassword: String) : Boolean{
        return password == reEnterPassword
    }

    fun SignInValidation(name: String,password: String) : String{
        if (name.isEmpty()){
            return "Email Field is empty"
        }else if (password.isEmpty()){
            return "Password Field is empty"
        }
        return "login"
    }
}