package com.oscarrecinos.parcial2.data.repository

import androidx.lifecycle.LiveData
import com.oscarrecinos.parcial2.data.dao.UsuarioDao
import com.oscarrecinos.parcial2.data.entity.Usuario

class RepositorioUsuario(private val usuarioDao : UsuarioDao){

    val LeerMayorMenorData : LiveData<List<Usuario>> = usuarioDao.ObtenerDataMayorAMenor()
    val LeerMenorMayorData : LiveData<List<Usuario>> = usuarioDao.ObtenerDataMenorAMayor()

    suspend fun AgregarUsuario(usuario : Usuario){
        usuarioDao.AgregarUsuario(usuario)
    }

}