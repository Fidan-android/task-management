package com.example.features.welcome.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.repository.FirstLaunchRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor
    (private val firstLaunchRepositoryImpl: FirstLaunchRepositoryImpl) : ViewModel() {

    fun onLetsStart() {
        viewModelScope.launch {
            firstLaunchRepositoryImpl.set()
        }
    }
}