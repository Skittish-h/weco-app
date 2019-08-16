package com.example.wecoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main2.*

class RegisterActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        reg_button.setOnClickListener {
            var uname = reg_uname.text.toString()
            var pwd = reg_pwd.text.toString()
            var email = reg_email.text.toString()
            if (email.isEmpty() || pwd.isEmpty() || uname.isEmpty()) return@setOnClickListener


            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pwd)
                .addOnCompleteListener {
                    if(!it.isSuccessful) return@addOnCompleteListener
                    //otherwise...
                    Log.d("Main", "Successful reg with uid: ${it.result.toString()}")
                }

        }
    }
}