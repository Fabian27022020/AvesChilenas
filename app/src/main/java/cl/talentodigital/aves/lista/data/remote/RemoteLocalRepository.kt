package cl.talentodigital.aves.lista.data.remote

import cl.talentodigital.aves.lista.domain.AveRepository
import cl.talentodigital.aves.lista.domain.model.Ave
import cl.talentodigital.aves.lista.domain.model.Aves

class RemoteLocalRepository(
    private val aveApi: AveApi
) : AveRepository {
    override suspend fun getAves(): Aves {
        return aveApi.getAveApi()
    }
}