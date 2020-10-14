package com.example.actitvityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var estado: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            textViewEstado.text = savedInstanceState.getString(EXTRA_STATE)
        }
        goToStateList()
    }

    private fun goToStateList() {
        button.setOnClickListener {
            startActivityForResult(Intent(this, StatesListActivity::class.java).apply {
                putExtra(
                    StatesListActivity.EXTRA_STATE,
                    estado
                )
            }, REQUEST_STATE)
        }
    }

    companion object {
        private const val REQUEST_STATE = 1
        private const val EXTRA_STATE = "estado"
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_CANCELED) return
        if (requestCode == REQUEST_STATE) {
            estado = data?.getStringExtra(StatesListActivity.EXTRA_RESULT)
            textViewEstado.text = estado
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EXTRA_STATE, estado)
    }


}