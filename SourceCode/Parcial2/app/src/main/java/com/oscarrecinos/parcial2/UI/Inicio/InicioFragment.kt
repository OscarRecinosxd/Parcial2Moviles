package com.oscarrecinos.parcial2.UI.Inicio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.oscarrecinos.parcial2.R

class InicioFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val IniciarTest = view.findViewById<Button>(R.id.IniciarTestButton)
        val VerTabla = view.findViewById<Button>(R.id.VerTablaJugadoresButton)
        val AniadirPreguntas = view.findViewById<Button>(R.id.AniadirPreguntasButton)

        IniciarTest.setOnClickListener {
            view.findNavController().navigate(R.id.ingresarUsuarioFragment)
        }
        VerTabla.setOnClickListener {
            view.findNavController().navigate(R.id.tablaUsuariosFragment)
        }
        AniadirPreguntas.setOnClickListener {
            view.findNavController().navigate(R.id.agregarPreguntaFragment)
        }
    }
}