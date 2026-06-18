package com.example.taskmanagement.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanagement.splash.data.repository.FirstLaunchRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor
    (private val firstLaunchRepositoryImpl: FirstLaunchRepositoryImpl) : ViewModel() {

    init {
        checkFirstLaunch()
    }

    private val _isFirstLaunch = MutableSharedFlow<Boolean>()
    val isFirstLaunch = _isFirstLaunch.asSharedFlow()

    private fun checkFirstLaunch() {
        viewModelScope.launch {
            val isFirstLaunch = firstLaunchRepositoryImpl.get()
            _isFirstLaunch.emit(!isFirstLaunch)
            /*if (!isFirstLaunch) {
                firstLaunchRepositoryImpl.set()
            }*/
        }
    }
}