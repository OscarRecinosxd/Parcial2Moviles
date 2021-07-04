package com.oscarrecinos.parcial2.UI.IngresarUsuario

import androidx.lifecycle.ViewModel
import com.oscarrecinos.parcial2.data.dao.PreguntaDao
import com.oscarrecinos.parcial2.data.dao.UsuarioDao
import com.oscarrecinos.parcial2.data.entity.Usuario

class IngresarUsuarioViewModel : ViewModel() {
    var Usuario : String = ""

    fun IngresarUsuario(_Usuario: String){
        Usuario = _Usuario
    }

}