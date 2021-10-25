package com.skreep.data.storage.sharedprefs

import android.content.Context
import com.skreep.data.storage.UserStorage
import com.skreep.data.storage.models.User

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_SAVE_NAME = "save_name"
private const val SAVE_MESSAGE = "Вы сохранили свое имя"
private const val REMOVE_MESSAGE = "Вы удалили свое имя"

class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)


    override fun get(): User {
        val name = sharedPreferences.getString(KEY_SAVE_NAME, "") ?: ""
        return User(name = name)
    }

    override fun save(user: User): String {
        sharedPreferences.edit().putString(KEY_SAVE_NAME, user.name).apply()
        return SAVE_MESSAGE
    }

    override fun clear(clearParam: User): String {
        sharedPreferences.edit().remove(KEY_SAVE_NAME).commit()
        return REMOVE_MESSAGE
    }
}