package com.skreep.cleanarchitectureproject.domain.usecases

import android.widget.Toast
import com.skreep.cleanarchitectureproject.domain.models.SaveUser
import com.skreep.cleanarchitectureproject.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUser): Boolean {
        val result: Boolean = userRepository.saveUserName(saveParam = param)
        return result
    }
}