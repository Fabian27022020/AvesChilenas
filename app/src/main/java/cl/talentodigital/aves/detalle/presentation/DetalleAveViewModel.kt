package cl.talentodigital.aves.detalle.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.talentodigital.aves.detalle.domain.DetalleAveUseCase
import cl.talentodigital.aves.detalle.domain.model.DetalleAve
import kotlinx.coroutines.launch

class DetalleAveViewModel (
    private val  detalleAveUseCase: DetalleAveUseCase
): ViewModel(){
    private val liveData = MutableLiveData<DetalleAveState>()

    fun getLiveData() = liveData

    fun obtenerDetalle(uid : String){
        liveData.postValue(DetalleAveState.LoadingDetalleState)
        viewModelScope.launch {
            try {
                val response = detalleAveUseCase.excecute(uid)
                handleRespose(response)
            }catch (exception : Exception){
                liveData.postValue(DetalleAveState.ErrorServerAvesState)
            }
        }
    }

    private fun handleRespose(response: DetalleAve) {
        response.uid.let{
            if (it != null) {
                if (it.isNotEmpty()){
                    liveData.postValue(DetalleAveState.SuccessAvesState(response))
                }else{
                    liveData.postValue(DetalleAveState.EmptyListAvesState)
                }
            }
        }

    }
}