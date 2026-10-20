package com.example.ejercicio1recetas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ejercicio1recetas.data.RecetaModel
import com.example.ejercicio1recetas.data.RecetaRepository
import com.example.ejercicio1recetas.data.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// Los tres estados posibles de la pantalla de lista
sealed interface RecetasUiState {
    data object Cargando : RecetasUiState
    data class Exito(val recetas: List<RecetaModel>) : RecetasUiState
    data class Error(val mensaje: String) : RecetasUiState
}

class RecetasViewModel : ViewModel() {

    private val repositorio = RecetaRepository(RetrofitClient.api)

    // Estado de la lista (privado y mutable; la UI solo ve la versión de solo lectura)
    private val _uiState = MutableStateFlow<RecetasUiState>(RecetasUiState.Cargando)
    val uiState: StateFlow<RecetasUiState> = _uiState

    // Receta que se muestra en la pantalla de detalle (null = cargando)
    private val _recetaSeleccionada = MutableStateFlow<RecetaModel?>(null)
    val recetaSeleccionada: StateFlow<RecetaModel?> = _recetaSeleccionada

    init {
        cargarRecetas()   // se pide la lista apenas se crea el ViewModel
    }

    fun cargarRecetas() {
        viewModelScope.launch {
            _uiState.value = RecetasUiState.Cargando
            _uiState.value = try {
                RecetasUiState.Exito(repositorio.obtenerRecetas())
            } catch (e: Exception) {
                RecetasUiState.Error("No se pudo cargar: ${e.message}")
            }
        }
    }

    fun buscar(texto: String) {
        // Si el cuadro de búsqueda está vacío, se vuelve a la lista completa
        if (texto.isBlank()) {
            cargarRecetas()
            return
        }
        viewModelScope.launch {
            _uiState.value = RecetasUiState.Cargando
            _uiState.value = try {
                RecetasUiState.Exito(repositorio.buscar(texto))
            } catch (e: Exception) {
                RecetasUiState.Error("Error en la búsqueda: ${e.message}")
            }
        }
    }

    fun cargarReceta(id: Int) {
        viewModelScope.launch {
            _recetaSeleccionada.value = null
            _recetaSeleccionada.value = try {
                repositorio.obtenerReceta(id)
            } catch (e: Exception) {
                null
            }
        }
    }
}
