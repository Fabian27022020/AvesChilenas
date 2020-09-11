package cl.talentodigital.aves.detalle.domain.model

import cl.talentodigital.aves.sessionlista.domain.model.NameAves


data class DetalleAve (
    val uid : String? = null,
    val name : NameAves? = null,
    val map : MapAve? = null,
    val iucn : IucnAve? = null,
    val habitat : String? = null,
    val didyouknow : String? = null,
    val size : String? = null,
    val species : String? = null,
    val audio : Audio? = null,
    val images : ImagesDetalle? = null
)