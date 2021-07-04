package com.oscarrecinos.parcial2.data.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oscarrecinos.parcial2.data.repository.RepositorioPreguntas
import com.oscarrecinos.parcial2.data.repository.RepositorioUsuario
import java.lang.Exception

class PoblarPreguntaViewModelFactory(private val repositorioPreguntas: RepositorioPreguntas, private val repositorioUsuario: RepositorioUsuario) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ExamenViewModel::class.java)){
            return ExamenViewModel(repositorioPreguntas,repositorioUsuario) as T
        }

        throw Exception("Unknown view model class")
    }
}