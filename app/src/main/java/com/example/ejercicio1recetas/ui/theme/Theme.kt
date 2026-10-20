package com.example.ejercicio1recetas.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = TomateClaro,
    onPrimary = CafeOscuro,
    secondary = Naranja,
    onSecondary = CafeOscuro,
    tertiary = Color(0xFF7BD8A8),
    background = CafeOscuro,
    onBackground = Color(0xFFFFEDE3),
    surface = Color(0xFF2A1D17),
    onSurface = Color(0xFFFFEDE3),
    surfaceVariant = Color(0xFF3F2E25),
    onSurfaceVariant = Color(0xFFE6CFC2)
)

private val LightColorScheme = lightColorScheme(
    primary = Tomate,
    onPrimary = Color.White,
    secondary = Naranja,
    onSecondary = Cafe,
    tertiary = Verde,
    onTertiary = Color.White,
    background = Crema,
    onBackground = Cafe,
    surface = Color.White,
    onSurface = Cafe,
    surfaceVariant = Color(0xFFFFE6D1),
    onSurfaceVariant = Color(0xFF5B4336)
)

@Composable
fun Ejercicio1RecetasTheme(
    // Tema claro por defecto: fondo crema y textos oscuros, legible en cualquier equipo.
    // Para seguir el modo del sistema, cambiar false por isSystemInDarkTheme()
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    // Se usa la paleta propia (sin colores dinámicos) para que la app se vea igual en todos los equipos
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
