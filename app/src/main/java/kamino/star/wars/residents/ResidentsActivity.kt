package kamino.star.wars.residents

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kamino.star.wars.R
import kamino.star.wars.util.BaseViewModelFactory
import java.util.*

class ResidentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holding_fragment)
        setupFragment()
    }

    private fun setupFragment() {
        val fragment = ResidentsFragment.newInstance(createViewModel())
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentHolder, fragment, ResidentsFragment.tag)
            .commit()
    }

    private fun createViewModel(): ResidentsViewModel {
        val residentUrls = intent.getStringArrayListExtra(residentUrlsExtraKey)
        return ViewModelProviders.of(this, BaseViewModelFactory {
            ResidentsViewModel(residentUrls)
        }).get(ResidentsViewModel::class.java)
    }

    companion object {
        const val residentUrlsExtraKey = "resident_urls"

        fun startActivity(context: Context, residentUrls: ArrayList<String>) {
            val intent = Intent(context, ResidentsActivity::class.java)
            val bundle = Bundle()
            bundle.putStringArrayList(residentUrlsExtraKey, residentUrls)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }
}
