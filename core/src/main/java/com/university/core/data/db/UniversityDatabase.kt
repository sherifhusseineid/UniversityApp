package com.university.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [UniversityEntity::class],
    version = 1,
    exportSchema = false
)
abstract class UniversityDatabase : RoomDatabase() {
    abstract fun universityDao(): UniversityDao
}
