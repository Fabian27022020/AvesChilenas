package cl.talentodigital.aves.lista.domain

class AveUseCase(
    private val repository: AveRepository
) {

    suspend fun excecute() = repository.getAves()


}