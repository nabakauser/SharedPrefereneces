package com.example.sharedprefereneces

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.sharedprefereneces.SharedPreferencesConstants.SHARED_PREFERENCES

class MySharedPreferences(context: Context) {

    private val mySharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor? = mySharedPreferences.edit()

    fun getName() : String? {
        return mySharedPreferences.getString(SharedPreferencesConstants.KEY_NAME, null)
    }

    fun setName(name: String?) {
        editor?.putString(SharedPreferencesConstants.KEY_NAME, name)?.apply()
    }


    fun getPassword() : String? {
        return mySharedPreferences.getString(SharedPreferencesConstants.KEY_PASSWORD, null)
    }
    fun setPassword(password: String?) {
        editor?.putString(SharedPreferencesConstants.KEY_PASSWORD, password)?.apply()
    }
}