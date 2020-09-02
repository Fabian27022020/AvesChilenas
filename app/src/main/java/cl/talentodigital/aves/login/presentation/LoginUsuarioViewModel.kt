package cl.talentodigital.aves.login.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.talentodigital.aves.login.domain.LoginUsuario
import cl.talentodigital.aves.login.domain.LoginUsuarioUseCase
import kotlinx.coroutines.launch

class LoginUsuarioViewModel (
    private val loginUsuarioUseCase: LoginUsuarioUseCase
) : ViewModel(){

    private val liveData = MutableLiveData<LoginUsuarioUiState>()

    fun getLiveData() = liveData

    fun doLogin(email : String, clave : String){
        liveData.postValue(LoginUsuarioUiState.Loading)
        viewModelScope.launch {
            try {
                val result =loginUsuarioUseCase.excecute(email, clave)
                handleResult(result)
            }catch (exception:Exception){
                handleError(exception)
            }

        }
    }


    private fun handleResult(result: LoginUsuario) {
        liveData.postValue(LoginUsuarioUiState.Success(result))
    }

    private fun handleError(exception: Throwable) {
        liveData.postValue(LoginUsuarioUiState.Error(exception))
    }

}