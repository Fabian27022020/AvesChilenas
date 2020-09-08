package cl.talentodigital.aves.sessionlista.data.remote

import cl.talentodigital.aves.sessionlista.domain.model.ImagesAves
import cl.talentodigital.aves.sessionlista.domain.model.LinksAves
import cl.talentodigital.aves.sessionlista.domain.model.NameAves

data class AveModel (
    val uid : String? = null,
    val name : NameAves? = null,
    val images : ImagesAves? = null,
    val links : LinksAves? = null,
    val  sort : Int? = null
)