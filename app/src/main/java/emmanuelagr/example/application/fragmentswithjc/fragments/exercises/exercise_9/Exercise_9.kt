package emmanuelagr.example.application.fragmentswithjc.fragments.exercises.exercise_9

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
fun Exercise_9(
    navController: NavController
) {
    var decades by remember { mutableStateOf("") }
    var result by remember { mutableStateOf(0L) }
    val visibility = remember { mutableStateOf(false) }

    @Composable
    fun CardBody() {
        OutlinedTextField(
            placeholder = { Text(text = "0") },
            label = { Text(text = "Décadas:") },
            value = decades,
            onValueChange = {
                if (it.contains(regex = Regex("^[0-9]+([0-9]+)?$")) && it.length <= 10
                    || it == ""
                ) {
                    decades = it
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
            topBar = { AppBar(title = "Ejercicio No. 9", navController = navController) }
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CardTemplate(
                    title = "Décadas a Días",
                    cardWidth = 300.dp,
                    cardHeight = 300.dp,
                    body = { CardBody() },
                    visibility = visibility,
                    onClick = { result = 3650 * if (decades != "") decades.toLong() else 0 },
                    result = "Días = $result"
                )
            }
        }
    }
}
