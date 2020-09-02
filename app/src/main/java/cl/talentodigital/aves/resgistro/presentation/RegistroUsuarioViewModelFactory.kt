package cl.talentodigital.aves.resgistro.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.aves.resgistro.domain.RegistroUsuarioUseCase

class RegistroUsuarioViewModelFactory(
    private val registroUsuarioUseCase: RegistroUsuarioUseCase
) : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {4
        return modelClass.getConstructor(RegistroUsuarioUseCase ::class.java)
            .newInstance(registroUsuarioUseCase)
    }


}