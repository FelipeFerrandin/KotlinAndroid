package com.example.activityandintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tala2.*

class Tela2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tala2)
        textResultadoMensagem.text = intent.getStringExtra("mensagem")
        val cliente = intent.getParcelableExtra<Cliente>("cliente")
        //textNomeCliente.text = "Nome:${cliente?.nome}, Id: ${cliente?.id}"
        val pessoa = intent.getSerializableExtra("pessoa") as Pessoa?
        textNomeCliente.text = "Nome:${pessoa?.nome}, Idade: ${pessoa?.idade}"

    }
}