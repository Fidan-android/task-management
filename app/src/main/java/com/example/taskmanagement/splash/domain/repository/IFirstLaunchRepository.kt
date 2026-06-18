package com.example.taskmanagement.splash.domain.repository

interface IFirstLaunchRepository {
    suspend fun set()
    suspend fun get(): Boolean
}