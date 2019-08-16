package com.example.wecoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_button.setOnClickListener {
            var pwd = log_pwd.text.toString()
            var usrn = log_email.text.toString()
            FirebaseAuth.getInstance().signInWithEmailAndPassword(usrn, pwd)
                .addOnCompleteListener{
                    if(!it.isSuccessful) return@addOnCompleteListener

                    //else

                    Log.d("login", "succc")
                }
        }
        signup.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }



}
