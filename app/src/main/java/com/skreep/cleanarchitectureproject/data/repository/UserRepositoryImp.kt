package com.skreep.cleanarchitectureproject.data.repository

import android.content.Context
import com.skreep.cleanarchitectureproject.domain.models.GetUserName
import com.skreep.cleanarchitectureproject.domain.models.SaveUser
import com.skreep.cleanarchitectureproject.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_SAVE_NAME = "save_name"
private const val SAVE_MESSAGE = "Вы сохранили свое имя"

class UserRepositoryImp(context: Context) : UserRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveUserName(saveParam: SaveUser): String {
        sharedPreferences.edit().putString(KEY_SAVE_NAME, saveParam.savename).apply()
        return SAVE_MESSAGE
    }

    override fun getUserName(): GetUserName {
        val name = sharedPreferences.getString(KEY_SAVE_NAME, "") ?: ""
        return GetUserName(name = name)
    }


}