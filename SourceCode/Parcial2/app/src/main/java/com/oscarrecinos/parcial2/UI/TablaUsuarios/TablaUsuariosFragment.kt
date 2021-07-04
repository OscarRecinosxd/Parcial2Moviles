package com.oscarrecinos.parcial2.UI.TablaUsuarios

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oscarrecinos.parcial2.PreguntaApplication
import com.oscarrecinos.parcial2.R
import com.oscarrecinos.parcial2.UsuarioApplication
import com.oscarrecinos.parcial2.data.ui.*
import com.oscarrecinos.parcial2.databinding.FragmentAgregarPreguntaBinding
import com.oscarrecinos.parcial2.databinding.FragmentTablaUsuariosBinding

class TablaUsuariosFragment : Fragment() {
    val usuarioAdapter = UsuariosAdapter()
    var contador = 0
    val dictApp2 by lazy {
        getActivity()?.getApplicationContext() as PreguntaApplication
    }

    private val usuarioViewModelFactory : UsuarioViewModelFactory by lazy {
        UsuarioViewModelFactory(dictApp2.UsuarioRepositorio)
    }
    private val usuarioViewModel : UsuarioViewModel by activityViewModels{
        usuarioViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tabla_usuarios, container, false)

        view.findViewById<RecyclerView>(R.id.UsuariosRV).apply {
            adapter = usuarioAdapter
            layoutManager = LinearLayoutManager(this@TablaUsuariosFragment.context)
        }

        usuarioViewModel.LeerMayorMenorData.observe(viewLifecycleOwner){
            usuarioAdapter.setData(it)
        }

        view.findViewById<Button>(R.id.OrdenarButton).setOnClickListener {
            if (contador % 2 == 0)
                usuarioViewModel.LeerMenorMayorData.observe(viewLifecycleOwner) {
                    usuarioAdapter.setData(it)
                    contador++
                }
            else {
                usuarioViewModel.LeerMayorMenorData.observe(viewLifecycleOwner) {
                    usuarioAdapter.setData(it)
                    contador++
                }
            }
        }
        return view
    }
}