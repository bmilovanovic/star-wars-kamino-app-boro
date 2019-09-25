package kamino.star.wars.residents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResidentsViewModel : ViewModel() {

    fun getLiveData(): LiveData<List<Resident>> {
        val liveData = MutableLiveData<List<Resident>>()
        val residentsList = mutableListOf<Resident>()
        residentsList.add(Resident())
        residentsList.add(Resident())
        residentsList.add(Resident())
        residentsList.add(Resident())
        residentsList.add(Resident())
        liveData.value = residentsList

        return liveData
    }

}
