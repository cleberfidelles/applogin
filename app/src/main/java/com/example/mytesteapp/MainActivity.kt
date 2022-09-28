package com.example.mytesteapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mytesteapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var view2 : ActivityMainBinding
    private  var auth =  FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view2 = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view2.root)
            entrar()
        cadastrar()


    }
    fun entrar(){
        view2.btnEntrar.setOnClickListener{
            val email = view2.pegaEmail.text.toString()
            val senha = view2.pegaSenha.text.toString()

            if(email.isEmpty() || senha.isEmpty()){
                val erro = Snackbar.make(it,"Preencha todos os campos!",Snackbar.LENGTH_SHORT)
                erro.setBackgroundTint(Color.RED)
                erro.show()
            }else{
                auth.signInWithEmailAndPassword(email,senha).addOnCompleteListener {autenticacao->
                    if (autenticacao.isSuccessful){
                        navegarTela()
                    }
                }
            }
        }
    }
    fun navegarTela(){
        var intencao = Intent(this,segundaTela::class.java )
        startActivity(intencao)
        finish()
    }
    fun cadastrar(){
        view2.textView2.setOnClickListener{
            var cad = Intent(this, cadastro::class.java)
            startActivity(cad)
            finish()
        }
    }
}
