package emmanuelagr.example.application.fragmentswithjc.fragments.exercises.exercise_1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import emmanuelagr.example.application.fragmentswithjc.components.AppBar
import emmanuelagr.example.application.fragmentswithjc.components.CardTemplate
import emmanuelagr.example.application.fragmentswithjc.ui.theme.FragmentsWithJCTheme

@Composable
fun Exercise_1(
    navController: NavController
) {
    var capacity by remember { mutableStateOf("") }
    var receives by remember { mutableStateOf("") }

    var result by remember { mutableStateOf(0.0) }
    val visibility = remember { mutableStateOf(false) }

    @Composable
    fun CardBody() {
        OutlinedTextField(
            placeholder = { Text(text = "0.0 cc") },
            label = { Text(text = "Capacidad de la Jarra:") },
            value = capacity,
            onValueChange = {
                if (it.contains(regex = Regex("^[0-9]+[.]?+([0-9]+)?$")) && it.length <= 10
                    || it == ""
                ) {
                    capacity = it
                    visibility.value = false
                }
            },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.secondary,
                placeholderColor = MaterialTheme.colors.secondary
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            placeholder = { Text(text = "0.0 cc") },
            label = { Text(text = "Cuanto recibe en un segundo:") },
            value = receives,
            onValueChange = {
                if (it.contains(regex = Regex("^[0-9]+[.]?+([0-9]+)?$")) && it.length <= 10
                    || it == ""
                ) {
                    receives = it
                    visibility.value = false
                }
            },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.secondary,
                placeholderColor = MaterialTheme.colors.secondary
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }

    FragmentsWithJCTheme {
        Scaffold(
            topBar = { AppBar(title = "Ejercicio No. 1", navController = navController) }
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CardTemplate(
                    title = "Tiempo en llenarse una Jarra",
                    cardWidth = 300.dp,
                    cardHeight = 350.dp,
                    body = { CardBody() },
                    visibility = visibility,
                    onClick = {
                        val receivesIn5Sg =
                            ((if (receives != "") receives.toDouble() else 0.0) * 5.0) * 0.05

                        result =
                            if (receivesIn5Sg != 0.0)
                                if (capacity != "")
                                    if (capacity.toDouble() > receives.toDouble() * 5.0)
                                        capacity.toDouble() / (receivesIn5Sg / 5.0)
                                    else capacity.toDouble() / receives.toDouble()
                                else 0.0
                            else 0.0
                    },
                    result = "Tiempo en llenarse = Aprox. ${
                        String.format(
                            "%.2f",
                            result
                        )
                    } segundos.",
                    resultSize = 15.sp
                )
            }
        }
    }
}