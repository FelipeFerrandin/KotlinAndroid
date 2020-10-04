package com.example.activityandintents

import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel
class ClienteComBibliotecaParceble(var nome: String, var codigo: Int) {
    // Este construtor esta sobrtescrevendo o construtor principal e atribuindo valores padroes
    // A anotacao indica que este construtor em especifico é usado pelo parceler
    @ParcelConstructor
    constructor() : this("", -1)
}