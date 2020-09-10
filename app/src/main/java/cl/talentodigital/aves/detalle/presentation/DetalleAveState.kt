package cl.talentodigital.aves.detalle.presentation

import cl.talentodigital.aves.detalle.domain.model.DetalleAve
import cl.talentodigital.aves.sessionlista.presentation.AvesUiState

sealed class DetalleAveState(
    open val result: DetalleAve? = null
) {

    object  LoadingDetalleState : DetalleAveState()
    data class SuccessAvesState (override  val result: DetalleAve): DetalleAveState(result = result)
    object  EmptyListAvesState : DetalleAveState()
    object  ErrorServerAvesState  : DetalleAveState()
    object  NotInternetAvesState : DetalleAveState()

}