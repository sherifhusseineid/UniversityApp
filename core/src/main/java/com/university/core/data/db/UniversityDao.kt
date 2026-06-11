package com.university.core.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UniversityDao {

    @Query("SELECT * FROM universities ORDER BY name ASC")
    suspend fun getAllUniversities(): List<UniversityEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(universities: List<UniversityEntity>)

    @Query("DELETE FROM universities")
    suspend fun deleteAll()
}
