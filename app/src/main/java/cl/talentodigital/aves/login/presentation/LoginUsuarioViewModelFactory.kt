package cl.talentodigital.aves.login.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.aves.login.domain.LoginUsuarioUseCase

class LoginUsuarioViewModelFactory(
    private val loginUsuarioUseCase: LoginUsuarioUseCase
) : ViewModelProvider.Factory{


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(LoginUsuarioUseCase ::class.java)
                .newInstance(loginUsuarioUseCase)
    }
}