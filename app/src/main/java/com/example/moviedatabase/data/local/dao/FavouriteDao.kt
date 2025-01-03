package com.example.moviedatabase.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviedatabase.data.local.entity.Favourite

@Dao
interface FavouriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favourite: Favourite)

    @Query("SELECT * FROM favourite")
    suspend fun getAllFavourites(): List<Favourite>
}