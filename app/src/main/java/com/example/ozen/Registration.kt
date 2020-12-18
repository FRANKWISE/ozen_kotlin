package com.example.ozen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registration.*


class Registration : AppCompatActivity() {

    private val auth by lazy  { FirebaseAuth.getInstance()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        button_reg.setOnClickListener {
            val intent = Intent (this, Podcasts::class.java)
            startActivity(intent)
        }
    }
}
