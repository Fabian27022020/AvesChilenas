package cl.talentodigital.aves.detalle.domain

class DetalleAveUseCase(
    private val repository: DetalleAveRepository
) {
    suspend fun excecute() = repository.obtenerDetalle()
}