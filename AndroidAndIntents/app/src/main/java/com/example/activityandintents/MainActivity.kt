package com.example.activityandintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonToast.setOnClickListener {
            Toast.makeText(this, "Primeiro Toast", Toast.LENGTH_LONG).show()
        }

        buttonTela2.setOnClickListener {
            startActivity(Intent(this, Tela2Activity::class.java).apply {
                putExtra("mensagem", editText.text.toString())
            })
        }

        buttonParcel.setOnClickListener {
            startActivity(Intent(this, Tela2Activity::class.java).apply {
                putExtra("cliente", Cliente(1, "Felipe"))
            })
        }

        buttonSerializeble.setOnClickListener {
            startActivity(Intent(this, Tela2Activity::class.java).apply {
                putExtra("pessoa", Pessoa("Felipe", 18))
            })
        }

    }
}