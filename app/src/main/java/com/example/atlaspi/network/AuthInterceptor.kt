package com.example.atlaspi.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor (private val tokenManager: TokenManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requisicaoOriginal = chain.request()
        val token = tokenManager.obterToken()

        val novaRequisicao = if (!token.isNullOrEmpty()){
            requisicaoOriginal.newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
        } else {
            requisicaoOriginal
        }

        return chain.proceed(novaRequisicao)
    }

}