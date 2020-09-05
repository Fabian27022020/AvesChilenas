package cl.talentodigital.aves.sessionlista.data.remote

import com.google.gson.annotations.SerializedName

data class AvesModel(
    @SerializedName("birds")
    val aves : List<AveModel>? = null
)
