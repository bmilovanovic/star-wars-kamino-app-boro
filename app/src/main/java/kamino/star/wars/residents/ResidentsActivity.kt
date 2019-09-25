package kamino.star.wars.residents

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kamino.star.wars.R

class ResidentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holding_fragment)
        setupFragment()
    }

    private fun setupFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentHolder, ResidentsFragment.newInstance(), ResidentsFragment.tag)
        transaction.commit()
    }

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, ResidentsActivity::class.java)
            context.startActivity(intent)
        }
    }
}
