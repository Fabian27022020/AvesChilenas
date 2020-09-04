package cl.talentodigital.aves.sessionlista.data.remote

import cl.talentgetAveApiodigital.aves.lista.data.remote.AveApi
import cl.talentodigital.aves.sessionlista.domain.AveRepository
import cl.talentodigital.aves.sessionlista.domain.model.Aves

class RemoteLocalRepository(
    private val aveApi: AveApi
) : AveRepository {
    override suspend fun getAves(): Aves {
        return aveApi.getAveApi()
    }
}