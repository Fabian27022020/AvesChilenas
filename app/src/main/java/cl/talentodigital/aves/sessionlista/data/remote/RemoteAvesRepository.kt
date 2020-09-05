package cl.talentodigital.aves.sessionlista.data.remote

import cl.talentodigital.aves.sessionlista.domain.AvesRepository
import cl.talentodigital.aves.sessionlista.domain.model.Aves

class RemoteAvesRepository(
    private val avesApi: AvesApi,
    private val aveMapper: AveMapper
) : AvesRepository {
    override suspend fun obtenerAves(): Aves {
        val aves  = avesApi.getAveApi()

        val listaTrasformada =
            aves.aves?.map { aveMapper.mapToEntity(it) } ?: emptyList()

        return Aves(listaTrasformada)
    }
}