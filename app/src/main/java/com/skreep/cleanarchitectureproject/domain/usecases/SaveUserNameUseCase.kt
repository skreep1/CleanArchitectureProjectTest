package com.skreep.cleanarchitectureproject.domain.usecases

import com.skreep.cleanarchitectureproject.domain.models.SaveUser
import com.skreep.cleanarchitectureproject.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(paramSave: SaveUser): String {
        val result: String = userRepository.saveUserName(saveParam = paramSave)
        return result
    }
}