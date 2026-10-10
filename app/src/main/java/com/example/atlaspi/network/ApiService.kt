package com.example.atlaspi.network

import com.example.atlaspi.models.LoginRequest
import com.example.atlaspi.models.LoginResponse
import com.example.atlaspi.models.MensagemResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("api/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("api/produtos")
    suspend fun listarProdutos(): Response<MensagemResponse>
}