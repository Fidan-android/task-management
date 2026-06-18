package com.example.taskmanagement.splash.data.di

import com.example.taskmanagement.splash.data.repository.FirstLaunchRepositoryImpl
import com.example.taskmanagement.splash.domain.repository.IFirstLaunchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FirstLaunchRepositoryModule {
    @Binds
    abstract fun bindFirstLaunchRepository(impl: FirstLaunchRepositoryImpl): IFirstLaunchRepository
}