import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun MainApp() {
    MaterialTheme {
        Surface {
            var isHomeScreen by remember { mutableStateOf(true) }

            if (isHomeScreen) {
                HomeScreen(onNavigate = { isHomeScreen = false })
            } else {
                ContentScreen()
            }
        }
    }
}

@Composable
fun ContentScreen() {
    val items = listOf(
        "Explorando composables",
        "Creación de interfaces dinámicas",
        "Realizado por Simon",
        "Aprendiendo Kotlin y Compose",
        "Manejando estado con remember",
        "Interactuando con layouts flexibles"
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items.forEach { itemText ->
            var isExpanded by remember { mutableStateOf(false) }
            var paddingValue by remember { mutableStateOf(0) }
            var buttonText by remember { mutableStateOf("Show More!") }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(12.dp)
                    .padding(bottom = paddingValue.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(itemText)
                Button(onClick = {
                    isExpanded = !isExpanded
                    paddingValue = if (isExpanded) 30 else 0
                    buttonText = if (isExpanded) "Show Less!" else "Show More!"
                }) {
                    Text(buttonText)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun HomeScreen(onNavigate: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("¡Bienvenido a Compose Desktop!")
        MaterialTheme {
            Button(onClick = onNavigate) {
                Text("Entrar")
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        MainApp()
    }
}
