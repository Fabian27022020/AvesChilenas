package cl.talentodigital.aves.sessionlista.domain

import cl.talentodigital.aves.sessionlista.domain.model.Aves
import io.reactivex.Single


interface AvesRepository  {
    suspend fun obtenerAves() : Aves
   // suspend fun  filtrarPorTexto(texto: String): Aves
}