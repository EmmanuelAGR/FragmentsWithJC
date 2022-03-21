package emmanuelagr.example.application.fragmentswithjc.fragments.exercises.exercise_4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class Exercise4Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = getComponent()

    private fun getComponent(): View =
        ComposeView(requireContext()).apply { setContent { Exercise_4(navController = findNavController()) } }
}