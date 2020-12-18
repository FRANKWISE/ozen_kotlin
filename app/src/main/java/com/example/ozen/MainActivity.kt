package com.example.ozen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val auth by lazy  { FirebaseAuth.getInstance()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonn.setOnClickListener {
            /****************************************************/
            signUp("test@gmail.com", "123465")
            val intent = Intent (this, Podcasts::class.java)
            startActivity(intent)
        }

        regtext.setOnClickListener {
            val intent = Intent (this, Registration::class.java)
            startActivity(intent)
        }

    }
    private fun signUp(
        email: String,
        password:String
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener  { task ->
                if(task.isSuccessful) {
                    Toast.makeText(this,"Success", Toast.LENGTH_LONG).show()

                    return@addOnCompleteListener
                }
                Toast.makeText(this,task.exception?.message, Toast.LENGTH_LONG).show()
            }
    }
}
