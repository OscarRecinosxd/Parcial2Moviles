package com.oscarrecinos.parcial2

import android.app.Application
import com.oscarrecinos.parcial2.data.BaseDeDatosPreguntas
import com.oscarrecinos.parcial2.data.BaseDeDatosUsuario
import com.oscarrecinos.parcial2.data.repository.RepositorioPreguntas
import com.oscarrecinos.parcial2.data.repository.RepositorioUsuario

class PreguntaApplication: Application() {
    private val database by lazy {
        BaseDeDatosPreguntas.getDatabase(this)
    }

    val PreguntaRepositorio by lazy{
        val preguntaDao = database.preguntaDao()
        RepositorioPreguntas(preguntaDao)
    }

    private val databaseUsuario by lazy {
        BaseDeDatosUsuario.getDatabase(this)
    }

    val UsuarioRepositorio by lazy{
        val usuarioDao = databaseUsuario.userDao()
        RepositorioUsuario(usuarioDao)
    }

}