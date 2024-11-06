package com.example.appmensagens.infra

import android.content.Context
import android.content.SharedPreferences

class Security(context: Context) {
    private val security: SharedPreferences =
        context.getSharedPreferences("AppMensagens", Context.MODE_PRIVATE)

    fun searchString(key: String, str: String){
        security.edit().putString(key, str).apply()
    }

    fun getString(key: String) : String{
        return security.getString(key, "")?:""
    }

}