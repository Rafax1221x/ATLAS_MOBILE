package com.example.marsphotos.data


import com.example.atlaspi.data.ApiPostUsuarioRepository
import com.example.atlaspi.data.NetworkApiPostUsuarioRepository
import com.example.atlaspi.network.ApiService
import com.example.atlaspi.network.AuthInterceptor
import com.example.atlaspi.network.TokenManager
import okhttp3.OkHttpClient
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {

    val apiPostUsuarioRepository : ApiPostUsuarioRepository

}


// é a aqui que acontece a definição da minha url, e a requisicao da Aplicação


val tokenManager = TokenManager(context)
val logging = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}
val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(AuthInterceptor(tokenManager))
    .addInterceptor(logging)
    .build()
//1 -
class DefaultAppContainer : AppContainer{

    private val BASE_URL = "http://10.0.2.2:3000"




    //Conversao de JSON para String
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    //Lazy, ele espera ser chamado para entrar no processo de funcionamento
    private val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val apiPostUsuarioRepository: ApiPostUsuarioRepository by lazy{
        NetworkApiPostUsuarioRepository(retrofitService)
    }


}






















































//package com.example.atlaspi.data
//
//import com.example.atlaspi.network.AuthInterceptor
//import com.example.atlaspi.network.TokenManager
//import android.content.Context
//import com.example.atlaspi.network.ApiService
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object NetworkClient {
//
//    private const val BASE_URL = "http://10.0.2.2:3000"
//
//
//    fun criarApiService(context: Context): ApiService {
//        val tokenManager = TokenManager(context)
//
//        val logging = HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        }
//
//        val okHttpClient = OkHttpClient.Builder()
//            .addInterceptor(AuthInterceptor(tokenManager))
//            .addInterceptor(logging)
//            .build()
//
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiService::class.java)
//    }
//
//}