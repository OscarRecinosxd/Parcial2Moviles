package com.oscarrecinos.parcial2.UI.FinExamen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.oscarrecinos.parcial2.R
import com.oscarrecinos.parcial2.UI.IngresarUsuario.IngresarUsuarioViewModel
import com.oscarrecinos.parcial2.data.ui.ExamenViewModel

class FinExamenFragment : Fragment() {

    val preguntasViewModel : ExamenViewModel by activityViewModels()

    lateinit var texto : TextView
    lateinit var Compartir : Button
    lateinit var Inicio : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fin_examen, container, false)

        texto = view.findViewById(R.id.TextoFinExamen)
        Compartir = view.findViewById(R.id.CompartirButton)
        Inicio = view.findViewById(R.id.InicioButton)

        texto.text = preguntasViewModel.Usuario + " te sometiste a "+ preguntasViewModel.IndiceAux.plus(1)+
                " preguntas y obtuviste "+ preguntasViewModel.PuntosAux+" puntos"

        Compartir.setOnClickListener{
            val texto = "Participe en el reto Conoce tu País El Salvador y gané "+preguntasViewModel.PuntosAux+
                    " puntos ¿Cuántos puedes tu? Prueba en: http://play.store.com/ongFaunaFloraElSalavador"
            val CompartirIntent = Intent()
            CompartirIntent.action = Intent.ACTION_SEND
            CompartirIntent.type = "text/plain"
            CompartirIntent.putExtra(Intent.EXTRA_TEXT,texto)
            CompartirIntent.putExtra(Intent.EXTRA_SUBJECT,"Subtema aqui")
            startActivity(Intent.createChooser(CompartirIntent,"Compartir en"))
        }

        Inicio.setOnClickListener{
            view.findNavController().navigate(R.id.inicioFragment)
        }

        return view
    }




}