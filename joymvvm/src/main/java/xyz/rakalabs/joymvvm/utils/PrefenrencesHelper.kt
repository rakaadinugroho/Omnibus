package xyz.rakalabs.joymvvm.utils

import android.content.Context
import android.preference.PreferenceManager
import java.lang.reflect.Array.set

class PrefenrencesHelper(context: Context) {
    companion object {
        const val DEVELOPMENT_MODE = false
    }
    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun prefString(keyName: String) = preferences.getString(keyName, "")
    fun prefBoolean(keyName: String) = preferences.getBoolean(keyName, false)
    fun prefInt(keyName: String) = preferences.getInt(keyName, 0)
    fun prefDouble(keyName: String) = preferences.getFloat(keyName, 0f)

    fun prefStringSet(keyName: String, value: String) = preferences.edit().putString(keyName, value).apply()
    fun prefBooleanSet(keyName: String, value: Boolean) = preferences.edit().putBoolean(keyName, value).apply()
    fun prefInt(keyName: String, value: Int) = preferences.edit().putInt(keyName, value).apply()
    fun prefDouble(keyName: String, value: Float) = preferences.edit().putFloat(keyName, value).apply()
}