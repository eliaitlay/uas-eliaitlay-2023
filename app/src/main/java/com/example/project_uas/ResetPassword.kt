package com.example.project_uas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.project_uas.databinding.ActivityResetPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class Resetpassword : AppCompatActivity() {

    private lateinit var  binding: ActivityResetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        binding = ActivityResetPasswordBinding.inflate (layoutInflater)

        binding.btnreset.setOnClickListener {
            val email : String = binding.edtemail.text.toString().trim()
            if (email.isEmpty()){
                binding.edtemail.error = "Input Email"
                binding.edtemail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.edtemail.error="Invalid email"
                binding.edtemail.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener{
                if (it.isSuccessful){
                    Toast.makeText(this, "cek email for reset password", Toast.LENGTH_SHORT).show()
                    Intent(this,LoginActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }
                else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
