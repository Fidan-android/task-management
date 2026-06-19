package com.example.core.di

import com.example.core.data.repository.FirstLaunchRepositoryImpl
import com.example.core.domain.repository.IFirstLaunchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindFirstLaunchRepository(impl: FirstLaunchRepositoryImpl): IFirstLaunchRepository
}