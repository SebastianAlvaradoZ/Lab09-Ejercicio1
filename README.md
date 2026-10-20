# Ejercicio 1 – Laboratorio 09: App de Recetas

Aplicación Android (Kotlin + Jetpack Compose) que consume el recurso **recipes**
de la API pública https://dummyjson.com/ usando Retrofit, Gson y Coil.

## Funcionalidades
- Lista de recetas con foto, puntuación, cocina, dificultad, tiempo y calorías
- Búsqueda de recetas por nombre (`/recipes/search?q=`)
- Pantalla de detalle con ingredientes y pasos de preparación
- Manejo de estados de carga, éxito y error (con botón "Reintentar")

## Arquitectura (MVVM)
- `data/`: `RecetaModel`, `RecetaApiService`, `RecetaRepository` (capa de datos)
- `viewmodel/`: `RecetasViewModel` (estado con `StateFlow`)
- `ui/`: pantallas y componentes de Jetpack Compose (solo observan el estado)

## Autor
SebastianAlvaradoZ
