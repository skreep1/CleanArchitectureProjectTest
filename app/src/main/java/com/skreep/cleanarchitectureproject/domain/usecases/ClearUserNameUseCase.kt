package com.skreep.cleanarchitectureproject.domain.usecases

import com.skreep.cleanarchitectureproject.domain.models.ClearUser
import com.skreep.cleanarchitectureproject.domain.repository.UserRepository

class ClearUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(clearUser: ClearUser) : String {
        val result: String = userRepository.clearUserName(clearParam = clearUser)
        return result
    }
}