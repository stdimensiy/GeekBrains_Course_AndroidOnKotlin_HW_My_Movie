package ru.geekbrains.androidonkotlin.hw.mymovie.domain.room

import androidx.room.*

@Dao
interface HistoryDao {
    @Query("SELECT * FROM SearchHistory")
    fun all(): List<SearchHistory>

    @Query("SELECT * FROM SearchHistory WHERE id LIKE :id")
    fun getDataById(id: Long): List<SearchHistory>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: SearchHistory)

    @Update
    fun update(entity: SearchHistory)

    @Delete
    fun delete(entity: SearchHistory)
}