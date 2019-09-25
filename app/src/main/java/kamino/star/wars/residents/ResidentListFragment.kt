package kamino.star.wars.residents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import kamino.star.wars.R

class ResidentListFragment : Fragment() {

    private lateinit var viewModel: ResidentListViewModel
    private lateinit var residentsList: RecyclerView
    private val residentsAdapter = ResidentsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_resident_list, container, false)
    }

    override fun onViewCreated(root: View, savedInstanceState: Bundle?) {
        residentsList = root.findViewById(R.id.residentsList)
        residentsList.adapter = residentsAdapter

        viewModel.getLiveData().observe(this, Observer<List<String>> {
            it?.let {
                this.updateUi(it)
            }
        })
    }

    private fun updateUi(residents: List<String>) {
        residentsAdapter.updateItems(residents)
    }

    companion object {
        const val tag = "ResidentListFragment"

        fun newInstance(viewModel: ResidentListViewModel): ResidentListFragment {
            val fragment = ResidentListFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }
}
