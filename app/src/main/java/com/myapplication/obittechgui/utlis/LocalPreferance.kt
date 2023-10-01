package com.myapplication.obittechgui.utlis

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.core.content.edit
import com.google.gson.Gson
import com.myapplication.obittechgui.Model.User

class LocalPreferance(private val mContext: Context?) {
    fun clear() {
        preferences?.edit {
            clear()
        }
    }

    var user: User?
        get() {
            val stUser = preferences?.getString("UserObje", "") ?:""
            if (stUser.isEmpty()) {
                return null
            }
            return Gson().fromJson(stUser, User::class.java)
        }
        set(newValue) {
            val userString = Gson().toJson(newValue)
            editor?.apply {
                putString("UserObje", userString)
                apply()
            }
        }

    var islogin:Boolean
    get(){

        return preferences?.getBoolean("Login", false)?:false
    }
    set(isLogin){
        editor?.apply{
            putBoolean("Login",isLogin)
            apply()
        }
    }

    var token: String?
        get() = preferences?.getString("AuthToken", "") ?: ""
        set(token) {
            editor?.apply {
                putString("AuthToken", token)
                apply()
            }
        }
    private var preferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null


    companion object {
        @JvmField
        var shared = LocalPreferance(BaseApplication.instance)
    }

    init {
        preferences = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            mContext?.getSharedPreferences(
                BaseApplication.instance?.packageName, Context.MODE_PRIVATE
            )
        } else {
            mContext?.getSharedPreferences(
                BaseApplication.instance?.packageName, Context.MODE_PRIVATE
            )
        }
        editor = preferences?.edit()
        editor?.apply()
    }
}