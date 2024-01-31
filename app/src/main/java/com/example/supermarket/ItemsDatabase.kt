package com.example.supermarket

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SuperMarketModel::class], version = 1)
abstract class ItemsDatabase : RoomDatabase() {
    abstract val itemsDao: ItemsDao


    companion object {
        @Volatile
        private var INSTANCE: ItemsDatabase? = null
        fun getDatabase(context: Context): ItemsDatabase {
            val temp = INSTANCE
            if(temp != null )
                return temp
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemsDatabase::class.java,
                    "itemDb"
                ).build()
                INSTANCE = instance

                return instance

            }
        }
    }
}
