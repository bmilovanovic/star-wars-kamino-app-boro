package kamino.star.wars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kamino.star.wars.home.HomeFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holding_fragment)
        setupFragment()
    }

    private fun setupFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentHolder, HomeFragment.newInstance(), HomeFragment.tag)
        transaction.commit()
    }
}
