package com.example.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Recuperando o email passado por meio da Intent
        val email = intent.getStringExtra("INTENT_EMAIL")

        //Acessar o arquivo de preferencias compartilhadas
        val sharedPrefs = getSharedPreferences("cadastro $email", Context.MODE_PRIVATE)

        //Recuperar dados no arquivo Shared Preferences
        val nome = sharedPrefs.getString("NOME", "")
        val sobrenome = sharedPrefs.getString("SOBRENOME", "")
        val genero = sharedPrefs.getString("GENERO", "não encontrado")

        //Exibir os dados recuperados na tela
        txvMainNome.text = "$nome $sobrenome"
        txvMainEmail.text = email
        txvMainGenero.text = genero

        //Executando o botão sair
        btnMainSair.setOnClickListener {

            //criando um alerta
            AlertDialog.Builder(this)
                .setTitle("Atenção!")
                .setMessage("Voce realmente deseja sair?")
                .setPositiveButton("Sim"){_,_ ->
                    //Executando o clique do botão sim
                    val mIntent = Intent(this, LoginActivity::class.java)
                    startActivity(mIntent)
                    finishAffinity()
                }
                .setNeutralButton("Cancelar"){_,_ ->}
                //Para que o usuário não saia do alerta quando clicar fora da caixa de diálogo
                .setCancelable(false)
                .create()
                .show()

        }
        //Execute o botão site Cellep
        btnMainSite.setOnClickListener {
             val mIntent = Intent(this, WebActivity::class.java)
             startActivity(mIntent)
                }
        }

    }
