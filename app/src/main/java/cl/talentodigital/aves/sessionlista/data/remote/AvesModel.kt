package cl.talentodigital.aves.sessionlista.data.remote

import cl.talentodigital.aves.sessionlista.domain.model.Ave
import com.google.gson.annotations.SerializedName

class AvesModel(
    @SerializedName("")
    val list: List<Ave>? = null
)