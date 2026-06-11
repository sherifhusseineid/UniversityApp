package com.university.core.di

import com.university.core.data.repository.UniversityRepository
import com.university.core.data.repository.UniversityRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUniversityRepository(
        impl: UniversityRepositoryImpl
    ): UniversityRepository
}
