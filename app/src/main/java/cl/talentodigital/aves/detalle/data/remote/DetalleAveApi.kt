package cl.talentodigital.aves.detalle.data.remote

import android.provider.MediaStore
import cl.talentodigital.aves.detalle.domain.model.Audio
import retrofit2.http.GET
import retrofit2.http.Path

interface DetalleAveApi {

    @GET("birds/{uid}")
    suspend fun getDetalleAveApi(@Path("uid") uid : String) : DetalleAveModel
}