package com.oscarrecinos.parcial2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oscarrecinos.parcial2.data.dao.PreguntaDao
import com.oscarrecinos.parcial2.data.entity.Pregunta


@Database(entities = [Pregunta::class], version = 1, exportSchema = false)
abstract class BaseDeDatosPreguntas : RoomDatabase() {

    abstract fun preguntaDao(): PreguntaDao

    companion object {
        @Volatile
        private var INSTANCE: BaseDeDatosPreguntas? = null

        fun getDatabase(context: Context): BaseDeDatosPreguntas{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDeDatosPreguntas::class.java,
                    "questions_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}