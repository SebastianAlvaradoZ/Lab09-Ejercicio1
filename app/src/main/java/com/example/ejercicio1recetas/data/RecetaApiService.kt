package com.example.ejercicio1recetas.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecetaApiService {

    // GET https://dummyjson.com/recipes?limit=30&skip=0
    @GET("recipes")
    suspend fun getRecetas(
        @Query("limit") limit: Int = 30,
        @Query("skip") skip: Int = 0
    ): RecetasResponse

    // GET https://dummyjson.com/recipes/5
    @GET("recipes/{id}")
    suspend fun getRecetaPorId(@Path("id") id: Int): RecetaModel

    // GET https://dummyjson.com/recipes/search?q=pizza
    @GET("recipes/search")
    suspend fun buscarRecetas(@Query("q") texto: String): RecetasResponse
}
