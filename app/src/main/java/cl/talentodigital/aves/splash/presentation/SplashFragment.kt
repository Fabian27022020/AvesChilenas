package cl.talentodigital.aves.splash.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import cl.talentodigital.aves.R
import cl.talentodigital.aves.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {

    lateinit var binding: FragmentSplashBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)
        setupListener()
    }

    private fun setupListener() {
        binding.btnIrALista.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_splashFragment_to_avesFragment)
        }
    }
}