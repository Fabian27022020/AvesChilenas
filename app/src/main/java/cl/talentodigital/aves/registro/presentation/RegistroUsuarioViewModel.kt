package cl.talentodigital.aves.registro.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.talentodigital.aves.registro.domain.RegistroUsuario
import cl.talentodigital.aves.registro.domain.RegistroUsuarioUseCase
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import kotlinx.coroutines.launch

class RegistroUsuarioViewModel (
    private val registroUsuarioUseCase: RegistroUsuarioUseCase
): ViewModel(){

    private val liveData = MutableLiveData<RegistroUsuarioUiState>()

    fun getLiveData() = liveData

    fun registrarUsuario(registroUsuario: RegistroUsuario){
        liveData.postValue(RegistroUsuarioUiState.LoadingRegistroUsuarioUiState)
        viewModelScope.launch {
            try {
                val result = registroUsuarioUseCase.excecute(registroUsuario)
                    handlerResult(result)
            }catch (exception : Exception){
                handlerError(exception)
            }
        }
    }

    private fun handlerResult(result: Boolean) {
        if (result){
            liveData.postValue(RegistroUsuarioUiState.SuccessRegistroUiState)
        }else{
            liveData.postValue(RegistroUsuarioUiState.InvalidEmailRegistroUiState)
        }
    }

    private fun handlerError(exception: Exception) {
        if (exception is FirebaseAuthUserCollisionException){
            liveData.postValue(RegistroUsuarioUiState.InvalidEmailRegistroUiState)
        }else{
            liveData.postValue(RegistroUsuarioUiState.ErrorRegistroUiState(exception))
        }
    }
}