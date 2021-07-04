package com.oscarrecinos.parcial2.data.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oscarrecinos.parcial2.data.repository.RepositorioUsuario
import java.lang.Exception

class UsuarioViewModelFactory(private val repositorioUsuario: RepositorioUsuario) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UsuarioViewModel::class.java)){
            return UsuarioViewModel(repositorioUsuario) as T
        }

        throw Exception("Unknown view model class")
    }
}