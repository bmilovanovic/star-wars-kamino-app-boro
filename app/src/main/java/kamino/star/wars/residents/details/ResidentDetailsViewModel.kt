package kamino.star.wars.residents.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kamino.star.wars.R
import kamino.star.wars.home.slider.Attribute
import kamino.star.wars.network.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResidentDetailsViewModel(private val residentId: Long) : ViewModel() {

    private val liveData = MutableLiveData<Resident>()

    fun getLiveData(): LiveData<Resident> {
        if (liveData.value == null) {
            fetchResident()
        }
        return liveData
    }

    private fun fetchResident() {
        Network.starWarsApi.getResident(residentId).enqueue(object : Callback<Resident> {
            override fun onResponse(call: Call<Resident>, response: Response<Resident>) {
                response.body()?.let { resident ->
                    parseAttributes(resident)
                    liveData.value = resident
                } ?: Runnable {
                    failed()
                }.run()
            }

            override fun onFailure(call: Call<Resident>, t: Throwable) {
                failed()
            }
        })
    }

    private fun parseAttributes(resident: Resident) {
        val list = mutableListOf<Attribute>()
        list.add(Attribute(R.string.height, resident.height.toString()))
        list.add(Attribute(R.string.mass, resident.mass))
        list.add(Attribute(R.string.hair_color, resident.hairColor))
        list.add(Attribute(R.string.skin_color, resident.skinColor))
        list.add(Attribute(R.string.eye_color, resident.eyeColor))
        list.add(Attribute(R.string.birth_year, resident.birthYear))
        list.add(Attribute(R.string.gender, resident.gender))
        resident.attributes = list
    }

    fun failed() {
        // Inform UI via state live data that network failed
    }
}
