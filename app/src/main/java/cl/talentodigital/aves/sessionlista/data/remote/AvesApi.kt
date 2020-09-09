package cl.talentodigital.aves.sessionlista.data.remote


import retrofit2.http.GET

interface AvesApi {
    @GET("birds/uid")
    suspend fun getAveApi() : List<AveModel>
}