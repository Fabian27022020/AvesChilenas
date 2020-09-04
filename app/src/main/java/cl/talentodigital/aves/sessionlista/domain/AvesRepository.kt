package cl.talentodigital.aves.sessionlista.domain

import cl.talentodigital.aves.sessionlista.domain.model.Aves


interface AvesRepository  {
    suspend fun obtenerAves() : Aves
}