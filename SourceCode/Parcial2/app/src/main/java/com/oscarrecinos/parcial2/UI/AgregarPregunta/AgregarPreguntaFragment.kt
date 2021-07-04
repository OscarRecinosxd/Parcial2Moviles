package com.oscarrecinos.parcial2.UI.AgregarPregunta

import androidx.appcompat.app.AppCompatActivity
import android.app.Application
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.oscarrecinos.parcial2.MainActivity
import com.oscarrecinos.parcial2.PreguntaApplication
import com.oscarrecinos.parcial2.data.entity.Pregunta
import com.oscarrecinos.parcial2.R
import com.oscarrecinos.parcial2.data.ui.PreguntaViewModel
import com.oscarrecinos.parcial2.data.ui.PreguntaViewModelFactory
import com.oscarrecinos.parcial2.databinding.FragmentAgregarPreguntaBinding

class AgregarPreguntaFragment : Fragment() {
    private var _binding : FragmentAgregarPreguntaBinding?= null
    private val binding get() = _binding!!

    val dictApp by lazy {
        getActivity()?.getApplicationContext() as PreguntaApplication
    }
    private val PreguntasViewModelFactory : PreguntaViewModelFactory by lazy {
        PreguntaViewModelFactory(dictApp.PreguntaRepositorio)
    }
    private val Preguntaviewmodel : PreguntaViewModel by activityViewModels{
        PreguntasViewModelFactory
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_agregar_pregunta, container, false)

        _binding = FragmentAgregarPreguntaBinding.inflate(inflater,container,false)
            .apply {
                viewModel = Preguntaviewmodel
                lifecycleOwner = viewLifecycleOwner
            }
        return binding.root
    }



}

