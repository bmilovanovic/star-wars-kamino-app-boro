package kamino.star.wars.network

import kamino.star.wars.home.Planet
import kamino.star.wars.residents.details.Resident
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface StarWarsInterface {

    @GET("planets/{planetId}")
    fun getPlanet(
        @Path("planetId") planetId: Long = 10L
    ): Call<Planet>

    @POST("planets/{planetId}/like")
    fun likePlanet(
        @Path("planetId") planetId: Long = 10L
    ): Call<LikeResult>

    @GET("residents/{residentId}")
    fun getResident(
        @Path("residentId") planetId: Long
    ): Call<Resident>
}
