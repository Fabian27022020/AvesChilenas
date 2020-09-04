package cl.talentodigital.aves.sessionlista.domain

class ObtenerAveUseCase(
    private val repository: AveRepository
) {

    suspend fun excecute() = repository.getAves()


}