package com.oscarrecinos.parcial2.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oscarrecinos.parcial2.data.entity.Usuario


@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun AgregarUsuario(Usuario : Usuario)

    @Query("SELECT *FROM user_table ORDER BY Puntos DESC ")
    fun ObtenerDataMayorAMenor(): LiveData<List<Usuario>>

    @Query("SELECT *FROM user_table ORDER BY Puntos ASC ")
    fun ObtenerDataMenorAMayor(): LiveData<List<Usuario>>
}