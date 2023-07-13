package br.gov.fatec.hotwheelscolletion.ui.activity

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.gov.fatec.hotwheelscolletion.R.layout.activity_login
import br.gov.fatec.hotwheelscolletion.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity(activity_login){
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val firebaseAuth = Firebase.auth


        val btnCadastrar = binding.activityLoginIrCadastrar
        val btnLogin = binding.activityLoginBotaoLogin

        btnLogin.setOnClickListener {
            val emailUser = binding.formularioLoginEmail.text.toString()
            val senha = binding.formularioLoginSenha.text.toString()
            autenticaUsuario(firebaseAuth, emailUser,senha)
        }

        btnCadastrar.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }

    }
    private fun autenticaUsuario(firebaseAuth: FirebaseAuth, email:String, senha: String) {
        firebaseAuth.signInWithEmailAndPassword("$email", "$senha")
            .addOnSuccessListener {
                Toast.makeText(this, "Usuário foi logado com sucesso", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ListaProdutosActivity::class.java))
            }.addOnFailureListener {
                Log.e(ContentValues.TAG, "onCreate: ", it)
                Toast.makeText(this, "Aconteceu uma falha ao logar", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, CadastroActivity::class.java))
            }
    }

}