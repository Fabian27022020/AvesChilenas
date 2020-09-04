package cl.talentgetAveApiodigital.aves.lista.data.remote

import cl.talentodigital.aves.sessionlista.domain.model.Aves

interface AveApi {

    suspend fun getAveApi() : Aves
}