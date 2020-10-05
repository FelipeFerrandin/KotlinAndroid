package com.example.activityandintents

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PessoaComBibliotecaExperimentalParcelize(var nome: String, var idade: Int) : Parcelable {
}