package com.skreep.cleanarchitectureproject.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    val livedata = MutableLiveData<String>()

    fun save(text: String) {
        val params = SaveUser(savename = text)
        livedata.value = saveUserNameUseCase.execute(paramSave = params)
    }

    fun load () {
        val username: GetUserName = getUserNameUseCase.execute()
        livedata.value = username.name
    }

    fun clear(text: String) {
        val params = ClearUser(clearUser = text)
        livedata.value =  clearUserNameUseCase.execute(clearUser = params)
    }
}