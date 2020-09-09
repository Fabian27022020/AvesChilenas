package cl.talentodigital.aves.detalle.data.remote

import cl.talentodigital.aves.detalle.domain.model.IucnAve
import cl.talentodigital.aves.detalle.domain.model.MapAve
import cl.talentodigital.aves.sessionlista.domain.model.NameAves

data class DetalleAveModel (
    val uid : String? = null,
    val name : NameAves? = null,
    val map : MapAve? = null,
    val iucn : IucnAve? = null,
    val species : String? = null
)