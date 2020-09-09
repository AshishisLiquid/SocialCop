package co.syntags.socialcop


import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import co.syntags.socialcop.fragments.AddNewsFragment
import co.syntags.socialcop.fragments.HomeFragment
import co.syntags.socialcop.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        if (savedInstanceState == null) {
            val fragment = HomeFragment()
            this.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        }
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {menuItem ->
        var selectedFragment: Fragment = HomeFragment()
        when (menuItem.itemId) {
            R.id.home ->
                selectedFragment = HomeFragment()

            R.id.add_new -> selectedFragment = AddNewsFragment()
            R.id.profile -> selectedFragment = ProfileFragment()
        }
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, selectedFragment)
        transaction.commit()
        return@OnNavigationItemSelectedListener true
    }
}