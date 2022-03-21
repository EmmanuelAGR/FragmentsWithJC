package emmanuelagr.example.application.fragmentswithjc.fragments.exercises.exercise_10

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import emmanuelagr.example.application.fragmentswithjc.components.AppBar
import emmanuelagr.example.application.fragmentswithjc.components.CardTemplate
import emmanuelagr.example.application.fragmentswithjc.ui.theme.FragmentsWithJCTheme

@Composable
fun Exercise_10(
    navController: NavController
) {
    var farenheit by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    val visibility = remember { mutableStateOf(false) }

    @Composable
    fun CardBody() {
        OutlinedTextField(
            placeholder = { Text(text = "0.0") },
            label = { Text(text = "Farenheit:") },
            value = farenheit,
            onValueChange = {
                if (it.contains(regex = Regex("^[0-9]+[.]?+([0-9]+)?$")) && it.length <= 10
                    || it == ""
                ) {
                    farenheit = it
                    visibility.value = false
                }
            },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.secondary,
                placeholderColor = MaterialTheme.colors.secondary
            )
        )
    }

    FragmentsWithJCTheme {
        Scaffold(
            topBar = { AppBar(title = "Ejercicio No. 10", navController = navController) }
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CardTemplate(
                    title = "Farenheit a Centígrados",
                    cardWidth = 300.dp,
                    cardHeight = 300.dp,
                    body = { CardBody() },
                    visibility = visibility,
                    onClick = {
                        result = String.format(
                            "%.0f",
                            5.0 / 9.0 * ((if (farenheit != "") farenheit.toDouble() else 0.0) - 32.0)
                        )
                    },
                    result = "Centígrados = $result °C"
                )
            }
        }
    }
}