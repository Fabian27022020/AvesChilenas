package cl.talentodigital.aves.sessionlista.domain


import cl.talentodigital.aves.sessionlista.domain.model.Aves

interface AveRepository  {
    suspend fun getAves() : Aves
}