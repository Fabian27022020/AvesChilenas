package cl.talentodigital.aves.sessionlista.data.remote


import retrofit2.http.GET

interface AvesApi {
    @GET("birds")
    suspend fun getAveApi() : AvesModel
}