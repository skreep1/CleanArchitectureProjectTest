package com.skreep.data.storage

import com.skreep.data.storage.models.User

interface UserStorage {

    fun get(): User

    fun save(user: User): String

    fun clear(clearParam: User): String
}