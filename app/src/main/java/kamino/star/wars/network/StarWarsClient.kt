package kamino.star.wars.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StarWarsClient {

    private val baseUrl = "https://private-anon-545ac3b965-starwars2.apiary-mock.com/"
    var retrofit: Retrofit
        private set

    init {
        val client = OkHttpClient.Builder().build()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}
