package cl.talentodigital.aves.sessionlista.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.aves.sessionlista.domain.ObtenerAveUseCase

class AveViewModelFactory (
    private val aveUseCase : ObtenerAveUseCase
) : ViewModelProvider.Factory{


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ObtenerAveUseCase::class.java)
            .newInstance(aveUseCase)
    }


}