package kamino.star.wars.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kamino.star.wars.network.Network
import kamino.star.wars.residents.ResidentsActivity
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
                response.body()?.let {
                    liveData.value = it
                } ?: Runnable {
                    failed()
                }.run()
            }

            override fun onFailure(call: Call<Planet>, t: Throwable) {
                failed()
            }
        })
    }

    fun failed() {
        // Inform UI via state live data that network failed
    }

    fun onResidentsClick(context: Context) {
        ResidentsActivity.startActivity(context)
    }
}
