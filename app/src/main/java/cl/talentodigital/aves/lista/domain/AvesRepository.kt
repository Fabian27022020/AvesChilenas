package cl.talentodigital.aves.lista.domain

import cl.talentodigital.aves.lista.domain.model.Ave

interface AvesRepository  {
    suspend fun getAves() : Ave
}