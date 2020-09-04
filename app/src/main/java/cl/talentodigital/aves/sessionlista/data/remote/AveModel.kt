package cl.talentodigital.aves.sessionlista.data.remote

import cl.talentodigital.aves.sessionlista.domain.model.Images
import cl.talentodigital.aves.sessionlista.domain.model.Name

data class AveModel (
    val uid : String? = null,
    val name : Name? = null,
    val images : Images? = null,
    val  sort : Int? = null
)