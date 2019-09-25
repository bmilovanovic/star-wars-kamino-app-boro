package kamino.star.wars.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kamino.star.wars.R
import kamino.star.wars.home.slider.Attribute
import kamino.star.wars.network.Network
import kamino.star.wars.residents.ResidentListActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val liveData = MutableLiveData<Planet>()

    fun getLiveData(): LiveData<Planet> {
        if (liveData.value == null) {
            fetchPlanet()
        }
        return liveData
    }

    private fun fetchPlanet() {
        Network.starWarsApi.getPlanet().enqueue(object : Callback<Planet> {
            override fun onResponse(call: Call<Planet>, response: Response<Planet>) {
                response.body()?.let { planet ->
                    parseAttributes(planet)
                    liveData.value = planet
                } ?: Runnable {
                    failed()
                }.run()
            }

            override fun onFailure(call: Call<Planet>, t: Throwable) {
                failed()
            }
        })
    }

    private fun parseAttributes(planet: Planet) {
        val list = mutableListOf<Attribute>()
        list.add(Attribute(R.string.rotation_period, planet.rotationPeriod.toString()))
        list.add(Attribute(R.string.orbital_period, planet.orbitalPeriod.toString()))
        list.add(Attribute(R.string.diameter, planet.diameter.toString()))
        list.add(Attribute(R.string.climate, planet.climate))
        list.add(Attribute(R.string.gravity, planet.gravity))
        list.add(Attribute(R.string.surface_water, planet.surfaceWater.toString()))
        list.add(Attribute(R.string.population, planet.population.toString()))
        planet.attributes = list
    }

    fun failed() {
        // Inform UI via state live data that network failed
    }

    fun onResidentsClick(context: Context) {
        liveData.value?.let {
            ResidentListActivity.startActivity(context, it.residentUrls)
        }
    }
}
