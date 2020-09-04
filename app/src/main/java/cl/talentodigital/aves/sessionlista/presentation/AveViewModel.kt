package cl.talentodigital.aves.sessionlista.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.talentodigital.aves.sessionlista.domain.ObtenerAveUseCase

class AveViewModel(
    private val obtenerAveUseCase: ObtenerAveUseCase
) : ViewModel(){

    private val liveData = MutableLiveData<AveUiState>()
    fun getLivaData() {

    }
    fun getLiveData() = liveData
}