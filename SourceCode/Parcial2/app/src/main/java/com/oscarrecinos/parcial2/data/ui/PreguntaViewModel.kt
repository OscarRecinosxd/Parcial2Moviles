package com.oscarrecinos.parcial2.data.ui

import android.widget.RadioGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscarrecinos.parcial2.data.entity.Pregunta
import com.oscarrecinos.parcial2.data.repository.RepositorioPreguntas
import kotlinx.coroutines.launch


class PreguntaViewModel(private val repositorioPreguntas: RepositorioPreguntas): ViewModel() {

    val Pregunta = MutableLiveData("")
    val opcionA = MutableLiveData("")
    val opcionB = MutableLiveData("")
    val opcionC = MutableLiveData("")
    val opcionD = MutableLiveData("")
    var opcionCorrecta = MutableLiveData("")
    val puntosPregunta = MutableLiveData("")
    var a : Boolean = false
    var b : Boolean = false
    var c : Boolean = false
    var d : Boolean = false
    fun asignarCorrecta(){
        if(a){
            opcionCorrecta.value ="A"
        }
        if(b){
            opcionCorrecta.value ="B"
        }
        if(c){
            opcionCorrecta.value ="C"
        }
        if(d){
            opcionCorrecta.value ="D"
        }
    }

    fun onSubmit() {
        asignarCorrecta()
        viewModelScope.launch {
            if (!Pregunta.value.isNullOrEmpty() && !opcionA.value.isNullOrEmpty() &&
                    !opcionB.value.isNullOrEmpty() && !opcionC.value.isNullOrEmpty() &&
                    !opcionD.value.isNullOrEmpty() && !opcionCorrecta.value.isNullOrEmpty() &&
                    !puntosPregunta.value.isNullOrEmpty()) {
                repositorioPreguntas.AgregarPregunta(
                        Pregunta(
                                Pregunta.value!!,
                                puntosPregunta.value.toString().toInt(),
                                opcionCorrecta.value!!,
                                opcionA.value!!,
                                opcionB.value!!,
                                opcionC.value!!,
                                opcionD.value!!
                        )
                )
                Pregunta.value = ""
                opcionA.value = ""
                opcionB.value = ""
                opcionC.value = ""
                opcionD.value = ""
                opcionCorrecta.value = ""
                puntosPregunta.value = ""
            }
        }
    }
}