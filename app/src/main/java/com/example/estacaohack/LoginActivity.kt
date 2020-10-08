package com.example.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Executando o click do botão
        btnLoginEntrar.setOnClickListener {

            //Capturar dados digitados pelo usuário
            val email = edtLoginEmail.text.toString().trim().toLowerCase()
            val senha = edtLoginSenha.text.toString().trim()

            //Validação dos campos
            if (email.isEmpty()) {
                edtLoginEmail.error = "Campo obrigatório"
                edtLoginEmail.requestFocus()
            }else if (senha.isEmpty()){
                edtLoginSenha.error = "Campo obrigatório"
                edtLoginSenha.requestFocus()
            }else{
                //Apresentar o arquivo de preferencias compartilhadas
                val sharedPrefs = getSharedPreferences("cadastro $email", Context.MODE_PRIVATE)

                //Recuperando dados no arquivo Shared Preferences
                val emailPrefs = sharedPrefs.getString("EMAIL", "")
                val senhaPrefs = sharedPrefs.getString("SENHA", "")

                //Verificando o email e senha que o usuário colocou
                if(email == emailPrefs && senha == senhaPrefs){
                    Toast.makeText(this, "Usuário logado com sucesso", Toast.LENGTH_SHORT).show()

                    //Abrindo a Main Activity
                    val mIntent = Intent(this, MainActivity::class.java)

                    //Passando informações através da Intent
                    mIntent.putExtra("INTENT_EMAIL", email)
                    startActivity(mIntent)
                    finish()
                }else{
                    //Apresentando uma mensagem de erro ao usuário
                    Toast.makeText(this, "Email ou senha inválidos", Toast.LENGTH_LONG).show()
                }
            }


        }

        //Executando o click do botão cadastrar
        btnLoginCadastrar.setOnClickListener {
            //Abrindo a tela de cadastro
            val mIntent = Intent(this, CadastroActivity::class.java)
            startActivity(mIntent)
        }

    }
}