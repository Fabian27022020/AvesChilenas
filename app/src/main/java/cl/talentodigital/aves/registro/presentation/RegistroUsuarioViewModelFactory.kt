package cl.talentodigital.aves.registro.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.aves.registro.domain.RegistroUsuarioUseCase

class RegistroUsuarioViewModelFactory(
    private val registroUsuarioUseCase: RegistroUsuarioUseCase
) : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {4
        return modelClass.getConstructor(RegistroUsuarioUseCase ::class.java)
            .newInstance(registroUsuarioUseCase)
    }


}