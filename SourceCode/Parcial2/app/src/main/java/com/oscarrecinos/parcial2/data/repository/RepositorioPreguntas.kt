package com.oscarrecinos.parcial2.data.repository

import androidx.lifecycle.LiveData
import com.oscarrecinos.parcial2.data.dao.PreguntaDao
import com.oscarrecinos.parcial2.data.entity.Pregunta

class RepositorioPreguntas(private val preguntaDao: PreguntaDao) {

    val LeerPreguntas : LiveData<List<Pregunta>> = preguntaDao.ObtenerPreguntas()


    suspend fun AgregarPregunta(pregunta : Pregunta){
        preguntaDao.AgregarPregunta(pregunta)
    }

}