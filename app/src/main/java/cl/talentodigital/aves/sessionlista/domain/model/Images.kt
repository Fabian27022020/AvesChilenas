package cl.talentodigital.aves.sessionlista.domain.model

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("main")
    val url : String

)