package com.skreep.cleanarchitectureproject.presentation

import androidx.lifecycle.ViewModel
import com.skreep.data.repository.UserRepositoryImp
import com.skreep.data.storage.sharedprefs.SharedPrefUserStorage
import com.skreep.domain.models.ClearUser
import com.skreep.domain.models.GetUserName
import com.skreep.domain.models.SaveUser
import com.skreep.domain.usecases.ClearUserNameUseCase
import com.skreep.domain.usecases.GetUserNameUseСase
import com.skreep.domain.usecases.SaveUserNameUseCase

class MainViewModel(
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase:GetUserNameUseСase,
    private val clearUserNameUseCase:ClearUserNameUseCase): ViewModel() {

    override fun onCleared() {
        super.onCleared()
    }

    fun save(text: String): String {
        val params = SaveUser(savename = text)
        return saveUserNameUseCase.execute(paramSave = params)
    }

    fun load () : String {
        val username: GetUserName = getUserNameUseCase.execute()
        return "${username.name}"
    }

    fun clear(text: String): String {
        val params = ClearUser(clearUser = text)
        return clearUserNameUseCase.execute(clearUser = params)
    }
}