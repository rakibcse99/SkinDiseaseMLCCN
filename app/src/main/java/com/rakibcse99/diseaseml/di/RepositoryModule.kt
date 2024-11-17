package com.rakibcse99.diseaseml.di

import com.rakibcse99.diseaseml.repository.model.CharacterRepository
import com.rakibcse99.diseaseml.repository.model.CharacterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun provideCharacterRepository(preference: CharacterRepositoryImpl): CharacterRepository
}