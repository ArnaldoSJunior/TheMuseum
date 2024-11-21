package br.edu.up.themuseum.data.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pedidos(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val nome : String,
    val cpf: String,
    val tel: String

){
    constructor(): this(null,"","","")
}

