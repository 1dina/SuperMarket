package com.example.supermarket

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ItemsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertItems ( item : SuperMarketModel)
    @Query("select * from superMarketItems")
    fun getItems():List<SuperMarketModel>
}