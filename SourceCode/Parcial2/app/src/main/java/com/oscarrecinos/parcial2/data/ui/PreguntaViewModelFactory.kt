package com.oscarrecinos.parcial2.data.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oscarrecinos.parcial2.data.repository.RepositorioPreguntas
import java.lang.Exception

class PreguntaViewModelFactory(private val repositorioPreguntas: RepositorioPreguntas) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PreguntaViewModel::class.java)){
            return PreguntaViewModel(repositorioPreguntas) as T
        }

        throw Exception("Unknown view model class")
    }
}