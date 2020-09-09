package cl.talentodigital.aves.detalle.data.remote

import retrofit2.http.GET

interface DetalleAveApi {

    @GET("birds/76-buteo-albigula")
    suspend fun getDetalleAveApi() : DetalleAveModel
}