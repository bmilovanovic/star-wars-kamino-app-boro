package kamino.star.wars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kamino.star.wars.home.HomeFragment
import kamino.star.wars.home.HomeViewModel

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holding_fragment)
        setupFragment()
    }

    private fun setupFragment() {
        val fragment = HomeFragment.newInstance(createViewModel())
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentHolder, fragment, HomeFragment.tag)
            .commit()
    }

    private fun createViewModel(): HomeViewModel {
        return ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }
}
