package com.example.core.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.example.core.domain.repository.IFirstLaunchRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class FirstLaunchRepositoryImpl @Inject constructor(private val dataStore: DataStore<Preferences>) :
    IFirstLaunchRepository {

    private companion object {
        val FIRST_LAUNCH = booleanPreferencesKey("first_launch")
    }

    override suspend fun set() {
        dataStore.edit { store ->
            store[FIRST_LAUNCH] = true
        }
    }

    override suspend fun get(): Boolean {
        return dataStore.data.first()[FIRST_LAUNCH] ?: false
    }
}