package kamino.star.wars.residents.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderView
import kamino.star.wars.R
import kamino.star.wars.home.slider.SliderAdapter

class ResidentDetailsFragment : Fragment() {

    private lateinit var viewModel: ResidentDetailsViewModel
    private lateinit var residentNameTextView: TextView
    private lateinit var residentImageView: ImageView
    private lateinit var imageSlider: SliderView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_resident_details, container, false)
    }

    override fun onViewCreated(root: View, savedInstanceState: Bundle?) {
        residentImageView = root.findViewById(R.id.residentImageView)
        residentNameTextView = root.findViewById(R.id.residentNameTextView)
        imageSlider = root.findViewById(R.id.imageSlider)

        viewModel.getLiveData().observe(this, Observer<Resident> {
            it?.let {
                this.updateUi(it)
            }
        })
    }

    private fun updateUi(resident: Resident) {
        loadImage(resident.imageUrl)
        residentNameTextView.text = resident.name
        imageSlider.sliderAdapter = SliderAdapter(resident.attributes)
    }

    private fun loadImage(imageUrl: String) {
        Glide.with(residentImageView)
            .load(imageUrl)
            .into(residentImageView)
    }

    companion object {
        const val tag = "ResidentDetailsFragment"

        fun newInstance(viewModel: ResidentDetailsViewModel): ResidentDetailsFragment {
            val fragment = ResidentDetailsFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }
}
