package cl.talentodigital.aves.lista.domain


import cl.talentodigital.aves.lista.domain.model.Aves

interface AveRepository  {
    suspend fun getAves() : Aves
}