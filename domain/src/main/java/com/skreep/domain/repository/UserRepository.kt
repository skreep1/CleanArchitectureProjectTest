package com.skreep.domain.repository

import com.skreep.domain.models.ClearUser
import com.skreep.domain.models.GetUserName
import com.skreep.domain.models.SaveUser

interface UserRepository {

    fun saveUserName(saveParam: SaveUser) : String

    fun getUserName() : GetUserName

    fun clearUserName(clearParam: ClearUser): String

}