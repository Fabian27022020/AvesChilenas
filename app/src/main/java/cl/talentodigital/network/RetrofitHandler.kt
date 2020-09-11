package cl.talentodigital.network

import cl.talentodigital.aves.detalle.data.remote.DetalleAveApi
import cl.talentodigital.aves.sessionlista.data.remote.AvesApi
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHandler {

    fun getRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl("https://aves.ninjas.cl/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun getAveApi() : AvesApi {
        return getRetrofit().create(AvesApi::class.java)
        }
    fun getDetalleApi():DetalleAveApi{
        return getRetrofit().create(DetalleAveApi::class.java)
    }
}