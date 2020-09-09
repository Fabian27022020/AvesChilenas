package cl.talentodigital.aves.detalle.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.aves.detalle.domain.DetalleAveUseCase

class DetalleAveViewModelFactory (
    private val detalleAveUseCase: DetalleAveUseCase
) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(DetalleAveUseCase ::class.java)
               .newInstance(detalleAveUseCase)
    }
}