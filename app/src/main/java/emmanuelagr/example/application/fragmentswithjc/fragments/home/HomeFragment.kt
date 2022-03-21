package emmanuelagr.example.application.fragmentswithjc.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = getComponent()

    private fun getComponent(): View =
        ComposeView(requireContext()).apply { setContent { HomeScreen(navController = findNavController()) } }
}