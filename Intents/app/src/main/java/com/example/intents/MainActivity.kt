package com.example.intents

import android.app.SearchManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.Settings
import android.provider.Settings.Global.getString
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listView = ListView(this)
        setContentView(listView)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.intent_actions)
        )
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            openIntentAtPosition(position)
        }
    }

    private fun callNumber() {
        val uri = Uri.parse("tel:429999999999")
        val intent = Intent(Intent.ACTION_CALL, uri)
        openIntent(intent)
    }

    private fun openIntentAtPosition(position: Int) {
        val uri: Uri?
        val intent: Intent?
        when (position) {
            0 -> {
                uri = Uri.parse("https://www.google.com")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            1 -> {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(android.Manifest.permission.CALL_PHONE),
                        0
                    )
                } else {
                    callNumber()
                }
            }
            2 -> {// Pesquisa uma posiçao do mapa
                // Seu aparelho deve ter o Google Maps
                uri = Uri.parse("geo:0,0?q=Rua+Amelia,Recife")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            3 -> { //Abrindo o editor de SMS
                uri = Uri.parse("sms:12345")
                intent = Intent(Intent.ACTION_VIEW, uri)
                    .putExtra("sms_body", "Corpo do SMS")
                openIntent(intent)
            }
            4 -> { //Compartilhar
                intent = Intent().setAction(Intent.ACTION_SEND)
                    .putExtra(Intent.EXTRA_TEXT, "Compartilhar via intent")
                    .setType("text/plain")
                openIntent(intent)
            }
            5 -> {// Alarme
                intent = Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "Estudar Android")
                    .putExtra(AlarmClock.EXTRA_HOUR, 19)
                    .putExtra(AlarmClock.EXTRA_MINUTES, 0)
                    .putExtra(AlarmClock.EXTRA_SKIP_UI, true)
                    .putExtra(
                        AlarmClock.EXTRA_DAYS, arrayListOf(
                            Calendar.MONDAY,
                            Calendar.WEDNESDAY,
                            Calendar.FRIDAY,
                        )
                    )
                openIntent(intent)
            }
            6 -> {// Buscar na web
                intent = Intent(Intent.ACTION_SEARCH).putExtra(SearchManager.QUERY, "Novatec")
                openIntent(intent)
            }
            7 -> {//Configuracoes do aparelho
                intent = Intent(Settings.ACTION_SETTINGS)
                openIntent(intent)
            }
            8 -> { // Ação personalizada 1
                intent = Intent("com.example.CUSTOM_ACTION")
                openIntent(intent)
            }
            9 -> {// Ação personalizada 2
                uri = Uri.parse("produto://Notebook/Slim")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            else -> finish()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.first() == PackageManager.PERMISSION_GRANTED) {
            callNumber()
        }
    }

    private fun openIntent(intent: Intent) {
        if (intent.resolveActivity(packageManager) == null) return
        startActivity(intent)
    }
}