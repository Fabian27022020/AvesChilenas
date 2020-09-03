package cl.talentodigital.aves.lista.domain

class AvesUseCase(
    private val repository: AvesRepository
) {

    suspend fun excecute() = repository.getAves()


}