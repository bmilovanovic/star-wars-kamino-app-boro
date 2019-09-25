package kamino.star.wars.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kamino.star.wars.residents.ResidentsActivity

class HomeViewModel : ViewModel() {

    fun getLiveData(): LiveData<Planet> {
        val liveData = MutableLiveData<Planet>()
        liveData.value = Planet()
        return liveData
    }

    fun onResidentsClick(context: Context) {
        ResidentsActivity.startActivity(context)
    }
}
