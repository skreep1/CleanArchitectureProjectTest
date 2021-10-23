package com.skreep.cleanarchitectureproject.domain.usecases

import com.skreep.cleanarchitectureproject.domain.models.GetUserName
import com.skreep.cleanarchitectureproject.domain.repository.UserRepository

class GetUserNameUseСase(private val userRepository: UserRepository) {

    fun execute() : GetUserName {
        return userRepository.getUserName()
    }


}