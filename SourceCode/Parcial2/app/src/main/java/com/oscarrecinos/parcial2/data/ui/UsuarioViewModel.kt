package com.oscarrecinos.parcial2.data.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.oscarrecinos.parcial2.data.BaseDeDatosUsuario
import com.oscarrecinos.parcial2.data.repository.RepositorioUsuario
import com.oscarrecinos.parcial2.data.entity.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioViewModel(repositorioUsuario: RepositorioUsuario): AndroidViewModel(Application()) {
    val LeerMayorMenorData : LiveData<List<Usuario>> = repositorioUsuario.LeerMayorMenorData
    val LeerMenorMayorData : LiveData<List<Usuario>> = repositorioUsuario.LeerMenorMayorData
}