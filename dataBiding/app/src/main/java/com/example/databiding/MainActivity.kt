package com.example.databiding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databiding.data.DataBindingModel
import com.example.databiding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(DataBindingModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        viewModel.clickAlterarNome.value = false
        viewModel.name.value = "Felipe"
        viewModel.lastName.value = "Ferrandin"
    }

    fun teste(view: View) {
        viewModel.clickAlterarNome.value = !viewModel.clickAlterarNome.value!!
    }

}