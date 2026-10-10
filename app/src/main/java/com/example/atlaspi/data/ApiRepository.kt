package com.example.atlaspi.data

import com.example.atlaspi.models.LoginRequest
import com.example.atlaspi.models.LoginResponse
import com.example.atlaspi.models.MensagemResponse
import com.example.atlaspi.network.ApiService
import com.example.marsphotos.data.tokenManager
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiPostUsuarioRepository {
    suspend fun login(emaildigitado: String,senhaDigitada: String)
}


class NetworkApiPostUsuarioRepository(
    private val apiService: ApiService
) : ApiPostUsuarioRepository {


    override suspend fun login(emailDigitado: String, senhaDigitada: String) {
        val respostaLogin = apiService.login(
            LoginRequest(email = emailDigitado, senha = senhaDigitada)
        )
        if (respostaLogin.isSuccessful) {
            val token = respostaLogin.body()!!.token
            tokenManager.guardarToken(token)
            println("Autenticado Usuãrio: ${respostaLogin.body()?.usuario?.email}")
        } else {
            println("Erro no login: ${respostaLogin.code()} - ${respostaLogin.errorBody()}")
        }

    }

}




//override suspend fun postUsuario(@Body request: LoginRequest): Response<LoginResponse> {
//    apiService.login(
//        LoginRequest(email = "", senha = "")
//    )
//}

