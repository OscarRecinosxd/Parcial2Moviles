package com.oscarrecinos.parcial2.UI.Examen

import android.content.res.Configuration
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.oscarrecinos.parcial2.MainActivity
import com.oscarrecinos.parcial2.PreguntaApplication
import com.oscarrecinos.parcial2.R
import com.oscarrecinos.parcial2.UI.IngresarUsuario.IngresarUsuarioFragment
import com.oscarrecinos.parcial2.UI.IngresarUsuario.IngresarUsuarioViewModel
import com.oscarrecinos.parcial2.data.entity.Pregunta
import com.oscarrecinos.parcial2.data.ui.ExamenViewModel
import com.oscarrecinos.parcial2.data.ui.PoblarPreguntaViewModelFactory
import com.oscarrecinos.parcial2.data.ui.PreguntaViewModel
import com.oscarrecinos.parcial2.data.ui.PreguntaViewModelFactory
import com.oscarrecinos.parcial2.databinding.FragmentAgregarPreguntaBinding
import com.oscarrecinos.parcial2.databinding.FragmentExamenBinding
import java.util.Observer


class ExamenFragment : Fragment() {
    private var tiempoRestante = ""
    private var _binding : FragmentExamenBinding?= null
    private val binding get() = _binding!!

    val dictApp by lazy {
        getActivity()?.getApplicationContext() as PreguntaApplication
    }

    private val PoblarPreguntasViewModelFactory : PoblarPreguntaViewModelFactory by lazy {
        PoblarPreguntaViewModelFactory(dictApp.PreguntaRepositorio,dictApp.UsuarioRepositorio)
    }
    private val preguntasViewModel : ExamenViewModel by activityViewModels{
        PoblarPreguntasViewModelFactory
    }
    val IngresarUsuarioViewModel : IngresarUsuarioViewModel by activityViewModels()


    val timer = object: CountDownTimer(120000, 10) {
        override fun onTick(millisUntilFinished: Long) {
            tiempoRestante = ((millisUntilFinished / 1000).toString())
            if(preguntasViewModel.indice == preguntasViewModel.TerminarIndice){
                tiempoRestante = ""
                preguntasViewModel.IngresarUsuario()
                preguntasViewModel.LimpiarVariables()
                view?.findNavController()?.navigate(R.id.finExamenFragment)
                cancel()
            }

        }

        override fun onFinish() {
            preguntasViewModel.IngresarUsuario()
            preguntasViewModel.LimpiarVariables()
            view?.findNavController()?.navigate(R.id.finExamenFragment)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        timer.start()
    }

    override fun onPause() {
        super.onPause()
        timer.cancel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_examen, container, false)

        timer.start()
        _binding = FragmentExamenBinding.inflate(inflater,container,false)
                .apply {
                    preguntasViewModel.view = view
                    configureListeners()
                    viewmodel = preguntasViewModel
                    lifecycleOwner = viewLifecycleOwner

                }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureListeners()
        view.findViewById<Button>(R.id.SiguientePregunta).setOnClickListener{
            configureListeners()
        }
    }

    fun configureListeners() {
        preguntasViewModel.preguntasLiveData.observe(viewLifecycleOwner) {
            preguntasViewModel.Usuario = IngresarUsuarioViewModel.Usuario
            preguntasViewModel.tiempo.value = tiempoRestante
            if(it.isNotEmpty()) {
                preguntasViewModel.bindearLista(it)
            }
            else{
                view?.findNavController()?.navigate(R.id.finExamenFragment)
            }


        }
    }

}