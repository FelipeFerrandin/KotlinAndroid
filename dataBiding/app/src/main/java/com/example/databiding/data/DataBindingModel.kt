package com.example.databiding.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataBindingModel : ViewModel() {
    val name = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    var clickAlterarNome = MutableLiveData<Boolean>()
}