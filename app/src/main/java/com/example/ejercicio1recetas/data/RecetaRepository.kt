package com.example.ejercicio1recetas.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Crea Retrofit una sola vez para toda la app (patrón singleton con "object")
object RetrofitClient {
    private const val BASE_URL = "https://dummyjson.com/"

    val api: RecetaApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecetaApiService::class.java)
    }
}

// Único punto de acceso a los datos: el ViewModel no conoce Retrofit
class RecetaRepository(private val api: RecetaApiService) {

    suspend fun obtenerRecetas(): List<RecetaModel> = api.getRecetas().recipes

    suspend fun obtenerReceta(id: Int): RecetaModel = api.getRecetaPorId(id)

    suspend fun buscar(texto: String): List<RecetaModel> = api.buscarRecetas(texto).recipes
}
