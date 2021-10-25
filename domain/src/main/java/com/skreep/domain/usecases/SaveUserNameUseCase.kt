package com.skreep.domain.usecases

import com.skreep.domain.models.SaveUser
import com.skreep.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(paramSave: SaveUser): String {
        val result: String = userRepository.saveUserName(saveParam = paramSave)
        return result
    }
}