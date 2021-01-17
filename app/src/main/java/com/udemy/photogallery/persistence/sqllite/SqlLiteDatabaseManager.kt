package com.udemy.photogallery.persistence.sqllite

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.udemy.photogallery.persistence.entities.FavoriteImageData


@Database(entities = [FavoriteImageData::class],version=1,exportSchema = false)
abstract class SqlLiteDatabaseManager:RoomDatabase() {


    abstract fun getFavoriteImageDAO():FavoriteImageDAO

    companion object{

        @Volatile
        private var instance:SqlLiteDatabaseManager?=null

        fun getDatabase(context: Context):SqlLiteDatabaseManager=
            instance?: synchronized(this){
                instance?: buildDatabase(context).also { instance=it }

            }

        private fun buildDatabase(context:Context)=
            Room.databaseBuilder(context.applicationContext,SqlLiteDatabaseManager::class.java,"images")
                .fallbackToDestructiveMigration()
                .build()

    }


}