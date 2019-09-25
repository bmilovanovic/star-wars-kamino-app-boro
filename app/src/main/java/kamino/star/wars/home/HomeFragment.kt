package kamino.star.wars.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import kamino.star.wars.R
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var planetImageView: ImageView
    private lateinit var planetNameTextView: TextView
    private lateinit var residentsButton: Button

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
        setPlanetImageExpand()
        planetNameTextView = root.findViewById(R.id.planetNameTextView)
        residentsButton = root.findViewById(R.id.residentsButton)
        residentsButton.setOnClickListener {
            viewModel.onResidentsClick(residentsButton.context)
        }

        viewModel.getLiveData().observe(this, Observer<Planet> {
            it?.let {
                this.updateUi(it)
            }
        })
    }

    private fun setPlanetImageExpand() {
        planetImageView.setOnClickListener {
            viewModel.getLiveData().value?.imageUrl?.let {
                ImageDialogFragment.newInstance(it).showAllowingStateLoss(
                    childFragmentManager, ImageDialogFragment.tag
                )
            }
        }
    }

    private fun updateUi(planet: Planet) {
        loadImage(planet.imageUrl)
        planetNameTextView.text = getString(R.string.planet_name, upperCase(planet.name))
    }

    private fun upperCase(text: String): String {
        return text.toUpperCase(Locale.getDefault())
    }

    private fun loadImage(imageUrl: String) {
        Glide.with(planetImageView)
            .load(imageUrl)
            .into(planetImageView)
    }

    companion object {
        const val tag = "HomeFragment"

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}
