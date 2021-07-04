package com.oscarrecinos.parcial2.data.ui

import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.oscarrecinos.parcial2.R
import com.oscarrecinos.parcial2.data.entity.Pregunta
import com.oscarrecinos.parcial2.data.entity.Usuario
import com.oscarrecinos.parcial2.data.repository.RepositorioPreguntas
import com.oscarrecinos.parcial2.data.repository.RepositorioUsuario
import kotlinx.coroutines.launch


class ExamenViewModel(private val repositorioPreguntas: RepositorioPreguntas,private val repositorioUsuario: RepositorioUsuario): ViewModel(){
    private var tiempoRestante = ""
    var tiempo = MutableLiveData("")
    var indice = 0
    var preguntasLiveData : LiveData<List<Pregunta>> = repositorioPreguntas.LeerPreguntas
    val Pregunta = MutableLiveData("")
    val OpcionA = MutableLiveData("")
    val OpcionB = MutableLiveData("")
    val OpcionC = MutableLiveData("")
    val OpcionD = MutableLiveData("")
    val RespuestaCorrecta = MutableLiveData("")
    val puntosString = MutableLiveData("")
    val PuntosAcumuladosString = MutableLiveData("")
    var puntosInt = 0
    var puntosAcumulados = 0
    var Usuario = ""
    var SeleccionadaA : Boolean = false
    var SeleccionadaB : Boolean = false
    var SeleccionadaC : Boolean = false
    var SeleccionadaD : Boolean = false
    var IndiceAux = 0
    var PuntosAux = 0
    var TerminarIndice = -2

    lateinit var view : View
    lateinit var item : Pregunta

    val timer = object: CountDownTimer(120000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            tiempoRestante = ((millisUntilFinished / 1000).toString());
            tiempo.value = tiempoRestante
        }
        override fun onFinish() {

        }
    }

    lateinit var Listaxd : List<Pregunta>

    fun bindearLista(Lista : List<Pregunta>){
        timer.start()
        Listaxd = Lista
        item = Listaxd[indice]
        Pregunta.value = item.Pregunta
        Log.d("Lista mapeo", Pregunta.value!!)
        OpcionA.value = item.OpcionA
        OpcionB.value = item.OpcionB
        OpcionC.value = item.OpcionC
        OpcionD.value = item.OpcionD
        RespuestaCorrecta.value = item.RespuestaCorrecta
        puntosInt = item.Puntos
        puntosString.value = item.Puntos.toString() + " puntos "
    }

    fun PoblarPregunta(){
        if(indice == Listaxd.lastIndex){
            calcularPuntos()
            TerminarIndice = Listaxd.lastIndex
            PuntosAux = puntosAcumulados
            timer.cancel()
        }
        else{
            calcularPuntos()
            indice++
            item = Listaxd[indice]
            Pregunta.value = item.Pregunta
            OpcionA.value = item.OpcionA
            OpcionB.value = item.OpcionB
            OpcionC.value = item.OpcionC
            OpcionD.value = item.OpcionD
            RespuestaCorrecta.value = item.RespuestaCorrecta
            puntosInt = item.Puntos
            puntosString.value = item.Puntos.toString() + " puntos "
            IndiceAux = indice
            PuntosAux = puntosAcumulados

        }
    }


    fun calcularPuntos(){
        if(SeleccionadaA && RespuestaCorrecta.value == "A"){
            puntosAcumulados += puntosInt
            PuntosAcumuladosString.value = "Puntos acumulados " + puntosAcumulados.toString()
        }
        else if(SeleccionadaB && RespuestaCorrecta.value == "B"){
            puntosAcumulados += puntosInt
            PuntosAcumuladosString.value = "Puntos acumulados " + puntosAcumulados.toString()
        }
        else if(SeleccionadaC && RespuestaCorrecta.value == "C"){
            puntosAcumulados += puntosInt
            PuntosAcumuladosString.value = "Puntos acumulados " + puntosAcumulados.toString()
        }
        else if(SeleccionadaD && RespuestaCorrecta.value == "D"){
            puntosAcumulados += puntosInt
            PuntosAcumuladosString.value = "Puntos acumulados " + puntosAcumulados.toString()
        }
    }

    fun IngresarUsuario() {
        viewModelScope.launch {
            if (Usuario!="") {
                repositorioUsuario.AgregarUsuario(Usuario(Usuario,puntosAcumulados))
            }
        }
    }

    fun LimpiarVariables(){
        tiempoRestante = ""
        tiempo = MutableLiveData("")
        indice = 0
        puntosAcumulados = 0
        Pregunta.value =  ""
        OpcionA.value =  ""
        OpcionB.value =  ""
        OpcionC.value =  ""
        OpcionD.value =  ""
        RespuestaCorrecta.value =  ""
        puntosString.value =  ""
        PuntosAcumuladosString.value =  ""
        puntosInt = 0
        SeleccionadaA = false
        SeleccionadaB = false
        SeleccionadaC = false
        SeleccionadaD = false
        TerminarIndice = -2
    }

    fun PoblarLista(){
        preguntasLiveData = repositorioPreguntas.LeerPreguntas
    }
}


