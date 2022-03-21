package emmanuelagr.example.application.fragmentswithjc.fragments.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import emmanuelagr.example.application.fragmentswithjc.components.ActivitiesList
import emmanuelagr.example.application.fragmentswithjc.components.AppBar
import emmanuelagr.example.application.fragmentswithjc.ui.theme.FragmentsWithJCTheme

@Composable
fun HomeScreen(
    navController: NavController
) {
    FragmentsWithJCTheme {
        Scaffold(
            topBar = { AppBar("FragmentsWithJC") },
            content = {
                ActivitiesList(navController)
            }
        )
    }
}