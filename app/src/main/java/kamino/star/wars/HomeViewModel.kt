package kamino.star.wars

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kamino.star.wars.model.Planet

class HomeViewModel : ViewModel() {

    fun getLiveData(): LiveData<Planet> {
        val liveData = MutableLiveData<Planet>()
        liveData.value = Planet()
        return liveData
    }
}
