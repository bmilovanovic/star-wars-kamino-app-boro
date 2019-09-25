package kamino.star.wars.residents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResidentListViewModel(private val residentUrls: List<String>) : ViewModel() {

    fun getLiveData(): LiveData<List<String>> {
        val liveData = MutableLiveData<List<String>>()
        liveData.value = residentUrls

        return liveData
    }

}
