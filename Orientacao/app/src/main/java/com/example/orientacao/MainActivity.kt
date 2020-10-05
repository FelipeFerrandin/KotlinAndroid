package com.example.orientacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var names = arrayListOf<String>()
    var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            this.names = savedInstanceState.getStringArrayList("names_list") as ArrayList<String>
        }
        prepareAdapter()
        addItensInList()
    }

    private fun prepareAdapter() {
        adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, names)
        listNomes.adapter = this.adapter
    }

    private fun addItensInList() {
        buttonAdicionar.setOnClickListener {
            names.add(editTextNome.text.toString())
            editTextNome.text.clear()
            adapter?.notifyDataSetChanged()

        }
    }

    //Metodo para salvar o necessario da tela antes de ser destruida é chamado depois do onPause e antes do onStop
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("names_list", this.names)
    }


}