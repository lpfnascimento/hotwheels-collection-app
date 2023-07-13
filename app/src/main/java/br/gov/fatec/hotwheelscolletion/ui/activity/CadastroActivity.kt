package br.gov.fatec.hotwheelscolletion.ui.activity

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.gov.fatec.hotwheelscolletion.R
import br.gov.fatec.hotwheelscolletion.databinding.ActivityCadastroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CadastroActivity : AppCompatActivity(R.layout.activity_cadastro) {

    private val binding by lazy {
        ActivityCadastroBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val firebaseAuth = Firebase.auth

        val botaoCadastro = binding.activityCadastroBotaoCadastrar

        botaoCadastro.setOnClickListener {
            val email = binding.formularioCadastroEmail.text.toString()
            val senha = binding.formularioCadastroPassword.text.toString()
            cadastraUsuario(firebaseAuth,email, senha)
        }
    }

    private fun cadastraUsuario(firebaseAuth:FirebaseAuth, email: String, senha: String) {

        val tarefa =
            firebaseAuth.createUserWithEmailAndPassword("$email", "$senha")
        tarefa.addOnSuccessListener {
            Toast.makeText(this, "Usuário foi cadastrado com sucesso", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
        }
        tarefa.addOnFailureListener {
            Log.e(TAG, "onCreate: ", it)
            Toast.makeText(this, "Aconteceu uma falha ao cadastrar $it", Toast.LENGTH_SHORT).show()
        }
    }
}