package cl.talentodigital.aves.sessionlista.domain.model

import com.google.gson.annotations.SerializedName

data class NameAves (
    @SerializedName("name")
    val spanish : String,
    val english : String,
    val latin : String
)