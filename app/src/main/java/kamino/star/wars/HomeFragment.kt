package kamino.star.wars

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kamino.star.wars.model.Planet

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var planetImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(root: View, savedInstanceState: Bundle?) {
        planetImageView = root.findViewById(R.id.planetImageView)

        viewModel.getLiveData().observe(this, Observer<Planet> {
            it?.let {
                this.updateUi(it)
            }
        })
    }

    private fun updateUi(planet: Planet) {
        planetImageView.setBackgroundColor(Color.RED)
    }

    companion object {
        const val tag = "HomeFragment"

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}
