package com.oscarrecinos.parcial2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oscarrecinos.parcial2.data.dao.UsuarioDao
import com.oscarrecinos.parcial2.data.entity.Usuario


@Database(entities = [Usuario::class], version = 1 , exportSchema = false)
abstract class BaseDeDatosUsuario : RoomDatabase() {

    abstract fun userDao(): UsuarioDao

    companion object {
        @Volatile
        private var INSTANCE: BaseDeDatosUsuario? = null

        fun getDatabase(context: Context): BaseDeDatosUsuario{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDeDatosUsuario::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}