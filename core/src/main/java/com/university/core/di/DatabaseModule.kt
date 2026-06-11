package com.university.core.di

import android.content.Context
import androidx.room.Room
import com.university.core.data.db.UniversityDao
import com.university.core.data.db.UniversityDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): UniversityDatabase =
        Room.databaseBuilder(
            context,
            UniversityDatabase::class.java,
            "university_database"
        ).build()

    @Provides
    @Singleton
    fun provideUniversityDao(database: UniversityDatabase): UniversityDao =
        database.universityDao()
}
