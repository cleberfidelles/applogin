package com.example.mytesteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mytesteapp.databinding.ActivityCadastroBinding
import com.google.firebase.auth.FirebaseAuth

class cadastro : AppCompatActivity() {
    private lateinit var view : ActivityCadastroBinding
    private var cadastro = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(view.root)
        view.cadastrar.setOnClickListener {
            val email = view.pegaEmail.text.toString()
            val senha = view.pegaSenha.text.toString()
            if (email.isEmpty() || senha.isEmpty()){
                Toast.makeText(this,"Preencha todos os campos",Toast.LENGTH_SHORT).show()
            }else{
                cadastro.createUserWithEmailAndPassword(email,senha).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "cadastro realizado com sucesso",Toast.LENGTH_SHORT).show()
                    }
                }.addOnFailureListener{
                    Toast.makeText(this,"Erro ao fazer o cadastro",Toast.LENGTH_SHORT)

                }
            }
        }

    }
}