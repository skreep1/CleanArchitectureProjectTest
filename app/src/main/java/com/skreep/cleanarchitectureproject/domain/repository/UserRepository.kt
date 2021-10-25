package com.skreep.cleanarchitectureproject.domain.repository

import android.widget.Toast
import com.skreep.cleanarchitectureproject.domain.models.ClearUser
import com.skreep.cleanarchitectureproject.domain.models.GetUserName
import com.skreep.cleanarchitectureproject.domain.models.SaveUser

interface UserRepository {

    fun saveUserName(saveParam: SaveUser) : String

    fun getUserName() : GetUserName

    fun clearUserName(clearParam: ClearUser): String

}