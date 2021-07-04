package com.oscarrecinos.parcial2.UI.IngresarUsuario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.oscarrecinos.parcial2.R

class IngresarUsuarioFragment : Fragment() {
    val IngresarUsuarioViewModel : IngresarUsuarioViewModel by activityViewModels()
    var Usuario = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_ingresar_usuario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val IngresarUsuarioText = view.findViewById<EditText>(R.id.IngresarUsuarioEditText)
        val IniciarExamen = view.findViewById<Button>(R.id.ComenzarExamenButton)
        IniciarExamen.setOnClickListener {
            IngresarUsuarioViewModel.IngresarUsuario(IngresarUsuarioText.text.toString())
            Usuario = IngresarUsuarioText.text.toString()
                if(Usuario!="") {
                    view.findNavController().navigate(R.id.examenFragment)
                }
        }
    }

}