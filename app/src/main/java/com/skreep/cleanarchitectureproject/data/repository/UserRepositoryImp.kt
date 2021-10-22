package com.skreep.cleanarchitectureproject.data.repository

import android.content.Context
import com.skreep.cleanarchitectureproject.domain.models.GetUserName
import com.skreep.cleanarchitectureproject.domain.models.SaveUser
import com.skreep.cleanarchitectureproject.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_LAST_NAME = "last_name"
private const val DEFAULT_NAME = "Default last name"

class UserRepositoryImp(context: Context) : UserRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)


    override fun saveUserName(saveParam: SaveUser): String {
        TODO("Not yet implemented")
    }

    override fun getUserName(getUser: GetUserName): String {
        val name = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""

        return GetUserName(name = name).toString()
    }
}