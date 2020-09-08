package cl.talentodigital.aves.sessionlista.domain.model

import com.google.gson.annotations.SerializedName

data class ImagesAves(
    @SerializedName("main")
    val url : String
)