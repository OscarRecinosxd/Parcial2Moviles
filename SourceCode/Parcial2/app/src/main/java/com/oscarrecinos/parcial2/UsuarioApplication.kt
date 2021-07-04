package com.oscarrecinos.parcial2

import android.app.Application
import com.oscarrecinos.parcial2.data.BaseDeDatosPreguntas
import com.oscarrecinos.parcial2.data.BaseDeDatosUsuario
import com.oscarrecinos.parcial2.data.repository.RepositorioPreguntas
import com.oscarrecinos.parcial2.data.repository.RepositorioUsuario

class UsuarioApplication: Application() {
    private val database by lazy {
        BaseDeDatosUsuario.getDatabase(this)
    }

    val UsuarioRepositorio by lazy{
        val usuarioDao = database.userDao()
        RepositorioUsuario(usuarioDao)
    }


}