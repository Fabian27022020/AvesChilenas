package cl.talentodigital.aves.login.presentation

import cl.talentodigital.aves.login.domain.LoginUsuario

sealed class LoginUsuarioUiState (
    open val result:LoginUsuario? = null,
    open val error : Throwable? = null
){
        object Loading : LoginUsuarioUiState()
        data class Success(override val result : LoginUsuario?) : LoginUsuarioUiState(result = result)
        data class Error(override val error:  Throwable?) : LoginUsuarioUiState(error = error)
        object InvalidUser: LoginUsuarioUiState()

}