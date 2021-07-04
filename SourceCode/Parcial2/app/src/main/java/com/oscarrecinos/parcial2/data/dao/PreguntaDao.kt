package com.oscarrecinos.parcial2.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oscarrecinos.parcial2.data.entity.Pregunta


@Dao
interface PreguntaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun AgregarPregunta(pregunta : Pregunta)



    @Query("SELECT * FROM PreguntasTabla ORDER BY Puntos ASC ")
    fun ObtenerPreguntas(): LiveData<List<Pregunta>>


}
