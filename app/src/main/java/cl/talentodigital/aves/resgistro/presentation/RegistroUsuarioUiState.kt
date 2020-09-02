package cl.talentodigital.aves.resgistro.presentation

sealed class RegistroUsuarioUiState(
    open val result: Boolean? = null,
    open val error : Throwable? = null
) {

        object LoadingRegistroUsuarioUiState : RegistroUsuarioUiState()
        object SuccessRegistroUiState : RegistroUsuarioUiState(result = true)
        object InvalidEmailRegistroUiState : RegistroUsuarioUiState(result = false)
        data class ErrorRegistroUiState(override val error: Throwable) : RegistroUsuarioUiState(error = error)
}

