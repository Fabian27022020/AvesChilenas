package cl.talentodigital.aves.lista.domain.model

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("main")
    val url : String

)