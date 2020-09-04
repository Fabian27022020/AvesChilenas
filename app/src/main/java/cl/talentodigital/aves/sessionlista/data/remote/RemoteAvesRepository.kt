package cl.talentodigital.aves.sessionlista.data.remote

import cl.talentgetAveApiodigital.aves.lista.data.remote.AvesApi
import cl.talentodigital.aves.sessionlista.domain.AvesRepository
import cl.talentodigital.aves.sessionlista.domain.model.Aves

class RemoteAvesRepository(
    private val avesApi: AvesApi,
    private val aveMapper: AveMapper
) : AvesRepository {
    override suspend fun obtenerAves(): Aves {
        val aves  = avesApi.getAveApi()

        val listaTrasformada =
            aves.listAves?.map { aveMapper.mapToEntity(it) } ?: emptyList()

        return Aves(listaTrasformada)
    }
}