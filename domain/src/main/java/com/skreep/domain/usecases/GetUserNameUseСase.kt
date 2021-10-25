package com.skreep.domain.usecases

import com.skreep.domain.models.GetUserName
import com.skreep.domain.repository.UserRepository

class GetUserNameUseСase(private val userRepository: UserRepository) {

    fun execute() : GetUserName {
        return userRepository.getUserName()
    }


}