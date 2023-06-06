package com.example.project_uas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.project_uas.databinding.ActivityLoginActivivityBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityLoginActivivityBinding
    private lateinit var  firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginActivivityBinding.inflate (layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnlogin.setOnClickListener {
            val email : String = binding.edtemail.text.toString().trim()
            val password : String = binding.edtPassword.text.toString().trim()

            if (email.isEmpty()){
                binding.edtemail.error ="Input Email"
                binding.edtemail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.edtemail.error = "Invalid Email"
                binding.edtemail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()||password.length < 6){
                binding.edtPassword.error = "Password more than 6 characters"
                binding.edtPassword.requestFocus()
                return@setOnClickListener
            }
            loginUser(email, password)

        }

        binding.edtreg.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        binding.resetpassword.setOnClickListener{
            Intent(this, Resetpassword::class.java).also {
                startActivity(it)
            }
        }

    }

    private fun  loginUser(email:String, password:String){
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
            if (it.isSuccessful){
                Intent(this, MainActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
            else{
                Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null){
            Intent(this, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }

}

