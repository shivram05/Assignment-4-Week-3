package com.example.assignment_4_week_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assignment_4_week_3.ValidationCheck.passwordValidation
import com.example.assignment_4_week_3.ValidationCheck.signupValidation
import com.example.assignment_4_week_3.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.continueButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val email = binding.mobileNumberOrEmailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val reEnterPassword = binding.reEnterPasswordTEditText.text.toString()

            val validationCheck = signupValidation(name, email, password, reEnterPassword)
            val passwordValidation = passwordValidation(password, reEnterPassword)
            if (validationCheck != "pass") {
                Toast.makeText(this, validationCheck, Toast.LENGTH_SHORT).show()
            } else if (!passwordValidation) {
                Toast.makeText(this, getString(R.string.password_doesn_t_match), Toast.LENGTH_SHORT)
                    .show()
            } else {
                PreDefinedUserCredentials.userCredentialsData()[name] = password
                startActivity(Intent(this, SignInActivity::class.java))
                finish()
            }
        }
    }
}