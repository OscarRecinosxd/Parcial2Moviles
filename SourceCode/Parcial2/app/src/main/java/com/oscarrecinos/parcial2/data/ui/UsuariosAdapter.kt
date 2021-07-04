package com.oscarrecinos.parcial2.data.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oscarrecinos.parcial2.R
import com.oscarrecinos.parcial2.data.entity.Usuario

class UsuariosAdapter() : RecyclerView.Adapter<UsuariosAdapter.UsuarioViewHolder>() {

    private var Usuario : List<Usuario>? = null

    class UsuarioViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {

        fun bind(usuario : Usuario){

            itemView.apply {
                findViewById<TextView>(R.id.UsuarioPuntaje).text = usuario.Nombre
                findViewById<TextView>(R.id.PuntosPuntaje).text = usuario.Puntos.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val card = LayoutInflater.from(parent.context) .
        inflate(R.layout.usuario_carta,parent,false)

        return UsuarioViewHolder(card)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        Usuario?.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount() = Usuario?.size ?: 0



    fun setData(usuarios: List<Usuario>){
        Usuario = usuarios
        notifyDataSetChanged()
    }
}