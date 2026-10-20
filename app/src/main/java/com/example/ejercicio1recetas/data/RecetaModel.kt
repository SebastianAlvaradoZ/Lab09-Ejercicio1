package com.example.ejercicio1recetas.data

import com.google.gson.annotations.SerializedName

// Una receta tal como la devuelve DummyJSON (/recipes/{id})
data class RecetaModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("ingredients") val ingredients: List<String>,
    @SerializedName("instructions") val instructions: List<String>,
    @SerializedName("prepTimeMinutes") val prepTimeMinutes: Int,
    @SerializedName("cookTimeMinutes") val cookTimeMinutes: Int,
    @SerializedName("servings") val servings: Int,
    @SerializedName("difficulty") val difficulty: String,
    @SerializedName("cuisine") val cuisine: String,
    @SerializedName("caloriesPerServing") val caloriesPerServing: Int,
    @SerializedName("tags") val tags: List<String>,
    @SerializedName("image") val image: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("reviewCount") val reviewCount: Int,
    @SerializedName("mealType") val mealType: List<String>
)

// El listado viene envuelto: { "recipes": [...], "total": 50, "skip": 0, "limit": 30 }
data class RecetasResponse(
    @SerializedName("recipes") val recipes: List<RecetaModel>,
    @SerializedName("total") val total: Int,
    @SerializedName("skip") val skip: Int,
    @SerializedName("limit") val limit: Int
)
