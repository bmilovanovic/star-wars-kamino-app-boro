package kamino.star.wars.network

import kamino.star.wars.home.Planet
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsInterface {

    @GET("planets/{planetId}")
    fun getPlanet(
        @Path("planetId") planetId: Long = 10L
    ): Call<Planet>
}
