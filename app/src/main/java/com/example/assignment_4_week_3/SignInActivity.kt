package com.example.assignment_4_week_3

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_4_week_3.ValidationCheck.SignInValidation
import com.example.assignment_4_week_3.databinding.ActivitySignInBinding


class SignInActivity : AppCompatActivity() {

    private lateinit var signInBinding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signInBinding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(signInBinding.root)

        signInBinding.checkBox.setOnClickListener {
            if (signInBinding.checkBox.isChecked) {
                signInBinding.passwordTextInputEditText.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                signInBinding.passwordTextInputEditText.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }
        signInBinding.signinButton.setOnClickListener {
            val constantUserData = PreDefinedUserCredentials.userCredentialsData()
            val email = signInBinding.emailTextInputEditText.text.toString()
            val password = signInBinding.passwordTextInputEditText.text.toString()

            val validationCheck = SignInValidation(email, password)
            if (validationCheck != "login") {
                Toast.makeText(this, validationCheck, Toast.LENGTH_SHORT).show()
            } else if (!constantUserData.containsKey(email) && !constantUserData.containsValue(
                    password
                )
            ) {
                Toast.makeText(
                    this,
                    getString(R.string.username_or_password_doesn_t_match),
                    Toast.LENGTH_SHORT
                ).show()
            } else if (validationCheck.equals("login") && constantUserData.containsKey(email) && constantUserData.containsValue(
                    password)) {
                startActivity(Intent(this, MainActivity::class.java).putExtra("username", email))
                Toast.makeText(this, getString(R.string.successfully_login), Toast.LENGTH_SHORT)
                    .show()
                finish()
            }
        }
        signInBinding.createNewAccount.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}