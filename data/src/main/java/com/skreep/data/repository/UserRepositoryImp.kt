package com.skreep.data.repository

import com.skreep.data.storage.models.User
import com.skreep.data.storage.UserStorage

import com.skreep.domain.models.ClearUser
import com.skreep.domain.models.GetUserName
import com.skreep.domain.models.SaveUser
import com.skreep.domain.repository.UserRepository


class UserRepositoryImp(private val userStorage: UserStorage) : UserRepository {


    override fun saveUserName(saveParam: SaveUser): String {

        val user = User(name = saveParam.savename)
        return userStorage.save(user)
    }

    override fun getUserName(): GetUserName {

        val user = userStorage.get()
        val userName = GetUserName(name = user.name)
        return userName

    }

    override fun clearUserName(clearParam: ClearUser): String {

        val user = User(name = clearParam.clearUser)
        return userStorage.clear(user)
    }


}