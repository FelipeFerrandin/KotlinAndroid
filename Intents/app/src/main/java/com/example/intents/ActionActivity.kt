package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_action.*

class ActionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)
        if (intent.action == Intent.ACTION_VIEW) {
            val uri = intent.data
            textAction.text = getString(R.string.custom_action2, uri.toString(), uri?.host, uri?.path)
        }else if (intent.action == "com.example.CUSTOM_ACTION"){
            textAction.text = getString(R.string.custom_action1)
        }
    }
}