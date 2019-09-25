package kamino.star.wars.residents.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kamino.star.wars.R
import kamino.star.wars.util.BaseViewModelFactory

class ResidentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holding_fragment)
        setupFragment()
    }

    private fun setupFragment() {
        val fragment = ResidentDetailsFragment.newInstance(createViewModel())
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragmentHolder, fragment,
                ResidentDetailsFragment.tag
            )
            .commit()
    }

    private fun createViewModel(): ResidentDetailsViewModel {
        val residentUrl = intent.getStringExtra(residentUrlExtra)
        val residentId =
            residentUrl.substring(residentUrl.lastIndexOf("/") + 1, residentUrl.length).toLong()
        return ViewModelProviders.of(this, BaseViewModelFactory {
            ResidentDetailsViewModel(residentId)
        }).get(ResidentDetailsViewModel::class.java)
    }

    companion object {
        const val residentUrlExtra = "resident_url"

        fun startActivity(context: Context, residentUrl: String) {
            val intent = Intent(context, ResidentDetailsActivity::class.java)
            intent.putExtra(residentUrlExtra, residentUrl)
            context.startActivity(intent)
        }
    }
}
