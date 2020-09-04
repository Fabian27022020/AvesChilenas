package cl.talentodigital.aves.sessionlista.data.remote

import cl.talentodigital.aves.sessionlista.domain.model.Ave
import com.google.gson.annotations.SerializedName

data class AvesModel(
    @SerializedName("birds")
    val listAves: List<AveModel>? = null
)
