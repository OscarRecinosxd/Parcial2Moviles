package com.oscarrecinos.parcial2.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class Usuario(
    @PrimaryKey
    val Nombre: String,
    val Puntos: Int


)