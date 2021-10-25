package com.skreep.domain.usecases

import com.skreep.domain.models.ClearUser
import com.skreep.domain.repository.UserRepository

class ClearUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(clearUser: ClearUser) : String {
        val result: String = userRepository.clearUserName(clearParam = clearUser)
        return result
    }
}