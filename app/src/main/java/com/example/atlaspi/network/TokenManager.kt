package com.example.atlaspi.network

import android.content.Context
import android.content.SharedPreferences

class TokenManager (context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    fun guardarToken(token: String) {
        prefs.edit().putString("JWT_TOKEN", token).apply()
    }

    fun obterToken(): String? {
        return prefs.getString("JWT_TOKEN",null)
    }

    fun limparToken() {
        prefs.edit().remove("JWT_TOKEN").apply()
    }

}