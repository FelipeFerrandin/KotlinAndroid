package com.example.activityandintents

import android.os.Parcel
import android.os.Parcelable

class Cliente(var id: Int, var nome: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    )

    //Este metodo serve para transformar os atributos da classe em bytes
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nome)
    }

    //Metodo que retorna um indentificador unico desta classe
    override fun describeContents(): Int {
        return 0
    }

    // Faz a criacao dos objetos do tipo parcel para deserializalo
    companion object CREATOR : Parcelable.Creator<Cliente> {
        // Lê os bytes e popula os atributos
        override fun createFromParcel(parcel: Parcel): Cliente {
            return Cliente(parcel)
        }

        override fun newArray(size: Int): Array<Cliente?> {
            return arrayOfNulls(size)
        }
    }
}