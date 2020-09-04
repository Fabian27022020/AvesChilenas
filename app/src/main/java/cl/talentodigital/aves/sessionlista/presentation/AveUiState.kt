package cl.talentodigital.aves.sessionlista.presentation

sealed class AveUiState {
    object Loading : AveUiState()
    object SuccessSession  : AveUiState()
    object InvalidSession : AveUiState()
}