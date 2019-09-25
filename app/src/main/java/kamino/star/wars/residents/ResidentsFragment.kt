package kamino.star.wars.residents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import kamino.star.wars.R

class ResidentsFragment : Fragment() {

    private lateinit var viewModel: ResidentsViewModel
    private lateinit var residentsList: RecyclerView
    private val residentsAdapter = ResidentsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ResidentsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_residents, container, false)
    }

    override fun onViewCreated(root: View, savedInstanceState: Bundle?) {
        residentsList = root.findViewById(R.id.residentsList)
        residentsList.adapter = residentsAdapter

        viewModel.getLiveData().observe(this, Observer<List<Resident>> {
            it?.let {
                this.updateUi(it)
            }
        })
    }

    private fun updateUi(residents: List<Resident>) {
        residentsAdapter.updateItems(residents)
    }

    companion object {
        const val tag = "ResidentsFragment"

        fun newInstance(): ResidentsFragment {
            return ResidentsFragment()
        }
    }
}
