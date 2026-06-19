package com.example.core.domain.repository

interface IFirstLaunchRepository {
    suspend fun set()
    suspend fun get(): Boolean
}