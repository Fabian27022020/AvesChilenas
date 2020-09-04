package cl.talentgetAveApiodigital.aves.lista.data.remote

import cl.talentodigital.aves.sessionlista.data.remote.AvesModel
import retrofit2.http.GET

interface AvesApi {
    @GET("birds")
    suspend fun getAveApi() : AvesModel
}