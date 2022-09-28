package com.example.mytesteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mytesteapp.databinding.ActivitySegundaTelaBinding
import com.google.firebase.auth.FirebaseAuth

class segundaTela : AppCompatActivity() {
    private lateinit var view : ActivitySegundaTelaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivitySegundaTelaBinding.inflate(layoutInflater)
        setContentView(view.root)
        view.sair.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            var intencao =  Intent(this,MainActivity::class.java)
            startActivity(intencao)
            finish()

        }
    }
}