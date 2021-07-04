package com.oscarrecinos.parcial2.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "PreguntasTabla")
data class Pregunta(
    @PrimaryKey
    val Pregunta:String,
    val Puntos:Int,
    val RespuestaCorrecta:String,
    val OpcionA:String,
    val OpcionB:String,
    val OpcionC:String,
    val OpcionD:String
)