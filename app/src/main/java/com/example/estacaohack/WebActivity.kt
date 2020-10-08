package com.example.estacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //Habilitar a execução de código javascript
        wbvSite.settings.javaScriptEnabled = true

        //Carregando um endereço web
        wbvSite.loadUrl("http://br.cellep.com/estacaohack")

        //Definindo o webView como cliente web padrão
            wbvSite.webViewClient = WebViewClient()

    }
}