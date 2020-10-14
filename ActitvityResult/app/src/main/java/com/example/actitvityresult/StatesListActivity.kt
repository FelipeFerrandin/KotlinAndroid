package com.example.actitvityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListView

class StatesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listView = ListView(this)
        setContentView(listView)
        val statesList = resources.getStringArray(R.array.estados)
        listView.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, statesList)
        listView.choiceMode = AbsListView.CHOICE_MODE_SINGLE
        val estado = intent.getStringExtra(EXTRA_STATE)
        if (estado != null) {
            val position = statesList.indexOf(statesList)
            listView.setItemChecked(position, true)
        }
        listView.setOnItemClickListener { parent, _, position, _ ->
            val result = parent.getItemAtPosition(position) as String
            val intent = Intent().putExtra(EXTRA_RESULT, result)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    companion object {
        const val EXTRA_STATE = "estado"
        const val EXTRA_RESULT = "result"
    }

}