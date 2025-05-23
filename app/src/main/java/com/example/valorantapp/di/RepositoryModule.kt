package com.example.valorantapp.di

import com.example.valorantapp.data.remote.ValorantService
import com.example.valorantapp.data.repository.ValorantRepositoryImpl
import com.example.valorantapp.domain.repository.ValorantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideValorantRepository(
        service: ValorantService
    ): ValorantRepository = ValorantRepositoryImpl(
        service = service
    )
}