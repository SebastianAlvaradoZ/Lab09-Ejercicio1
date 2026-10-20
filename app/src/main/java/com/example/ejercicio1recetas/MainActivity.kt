package com.example.ejercicio1recetas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ejercicio1recetas.ui.ScreenDetalle
import com.example.ejercicio1recetas.ui.ScreenRecetas
import com.example.ejercicio1recetas.ui.theme.Ejercicio1RecetasTheme
import com.example.ejercicio1recetas.viewmodel.RecetasViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()   // la app dibuja detrás de las barras del sistema
        setContent {
            Ejercicio1RecetasTheme {
                AppRecetas()
            }
        }
    }
}

@Composable
fun AppRecetas() {
    val navController = rememberNavController()

    // Un solo ViewModel compartido por las dos pantallas; sobrevive a rotaciones
    val viewModel: RecetasViewModel = viewModel()

    NavHost(navController = navController, startDestination = "lista") {
        composable("lista") {
            ScreenRecetas(
                viewModel = viewModel,
                onRecetaClick = { id -> navController.navigate("detalle/$id") }
            )
        }
        composable(
            route = "detalle/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { entrada ->
            ScreenDetalle(
                viewModel = viewModel,
                id = entrada.arguments!!.getInt("id"),
                onVolver = { navController.popBackStack() }
            )
        }
    }
}
