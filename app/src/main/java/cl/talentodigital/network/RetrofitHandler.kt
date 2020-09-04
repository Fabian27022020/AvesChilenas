package cl.talentodigital.network

import cl.talentgetAveApiodigital.aves.lista.data.remote.AveApi
import com.google.gson.GsonBuilder
import com.squareup.okhttp.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHandler {

  fun getRetrofit() : Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Build().addInterceptor(interceptor).build()
        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl("https://aves.ninjas.cl/api/birds")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
           // .addCallAdapterFactory()
            .build()
    }

    fun getAveApi() : AveApi{
        return getRetrofit().create(AveApi::class.java)
    }
}