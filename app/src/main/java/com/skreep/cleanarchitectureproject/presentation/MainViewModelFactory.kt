package com.skreep.cleanarchitectureproject.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.skreep.data.repository.UserRepositoryImp
import com.skreep.data.storage.sharedprefs.SharedPrefUserStorage
import com.skreep.domain.usecases.ClearUserNameUseCase
import com.skreep.domain.usecases.GetUserNameUseСase
import com.skreep.domain.usecases.SaveUserNameUseCase

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImp(userStorage = SharedPrefUserStorage(context = context))
    }

    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository = userRepository)
    }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseСase(userRepository = userRepository)
    }

    private val clearUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        ClearUserNameUseCase(userRepository = userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            saveUserNameUseCase = saveUserNameUseCase,
            getUserNameUseCase = getUserNameUseCase,
            clearUserNameUseCase = clearUserNameUseCase) as T
    }
}