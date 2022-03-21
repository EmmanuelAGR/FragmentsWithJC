package emmanuelagr.example.application.fragmentswithjc.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import emmanuelagr.example.application.fragmentswithjc.R

data class Activities(
    val title: String,
    val description: String,
    val img: Int,
    val imgDescription: String,
    val route: Int = 0
)

val activies = listOf(
    Activities(
        "Tiempo en llenarse una Jarra",
        "Calcular cuanto tiempo tarda en llenarse una jarra con una perdida del 5% cada 5 segundos.",
        R.drawable.derramando_agua_em_vidro,
        "Jug",
        R.id.action_homeFragment4_to_exercise1Fragment
    ),
    Activities(
        "Acierta el Número",
        "Entra ahora y desafiate a ti mismo en encontrar el número entre el 1 al 1000.",
        R.drawable.search_the_number,
        "Guess the number",
        R.id.action_homeFragment4_to_exercise2Fragment
    ),
    Activities(
        "Division usando Restas",
        "Según dos números enteros positivos, mostrar el residuo y el consiente usando restas.",
        R.drawable.fraction,
        "Division using subtraction",
        R.id.action_homeFragment4_to_exercise3Fragment
    ),
    Activities(
        "Invertir Número Entero",
        "Dale la vuelta al número que quieras.",
        R.drawable.invert_integer,
        "Invert integer",
        R.id.action_homeFragment4_to_exercise4Fragment
    ),
    Activities(
        "Descuento Aleatorio",
        "Solo por hoy, escoge aleatoreamente una bola de color con un descuento para toda tu factura.",
        R.drawable.discount,
        "Random discount",
        R.id.action_homeFragment4_to_exercise5Fragment
    ),
    Activities(
        "Nómina semanal",
        "Es cuando los trabajadores reciben su salario cada semana.",
        R.drawable.nomina_semanal,
        "Weekly payroll",
        R.id.action_homeFragment4_to_exercise6Fragment
    ),
    Activities(
        "Masa de Aire",
        "Representa la proporción de la atmósfera que la luz debe atravesar antes de " +
                "golpear la Tierra.",
        R.drawable.world,
        "Air mass",
        R.id.action_homeFragment4_to_exercise7Fragment
    ),
    Activities(
        "Número de pulsaciones por cada 10 segundos",
        "Aporta información relevante sobre el estado de salud del paciente.",
        R.drawable.icono_de_coraz_n_rojo_con_latidos,
        "Number of pulses per 10 seconds",
        R.id.action_homeFragment4_to_exercise8Fragment
    ),
    Activities(
        "Décadas a Días",
        "Período de diez años referido a las decenas de siglo.",
        R.drawable._10_anos,
        "Decades to Days",
        R.id.action_homeFragment4_to_exercise9Fragment
    ),
    Activities(
        "Farenheit a Centígrados",
        "El grado centígrado, es la unidad termométrica cuyo 0 se ubica 0.01 grados por " +
                "debajo del punto triple del agua.",
        R.drawable.thermometer_cf,
        "Fahrenheit to Centigrade",
        R.id.action_homeFragment4_to_exercise10Fragment
    )
)

@Composable
fun ActivitiesList(navController: NavController) {
    LazyColumn(content = {
        items(activies) { activity ->
            PillCard(
                title = activity.title,
                description = activity.description,
                img = activity.img,
                imgDescription = activity.imgDescription,
                onClick = { navController.navigate(activity.route) }
            )
        }
    })
}