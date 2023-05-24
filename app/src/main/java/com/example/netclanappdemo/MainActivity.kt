package com.example.netclanappdemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.netclanappdemo.databinding.ActivityMainBinding
import com.example.netclanappdemo.view.*
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerlayout)

        val navView: NavigationView = findViewById(R.id.nav_view)
        // navView.itemIconTintList
        navView.setItemIconTintList(null)


        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val toolbarMenuIcon = findViewById<ImageView>(R.id.mytool)
        toolbarMenuIcon.setOnClickListener {
            // Open the navigation drawer
            drawerLayout.openDrawer(GravityCompat.START)
        }


        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_profile -> Toast.makeText(
                    applicationContext,
                    "home clicked",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_network -> Toast.makeText(
                    applicationContext,
                    "Messageclicked",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_merchant -> Toast.makeText(
                    applicationContext,
                    "Setting",
                    Toast.LENGTH_SHORT
                ).show()


            }
            true
        }



        loadFragment(RefineFragment())
        //  binding.bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.refine -> {
                    loadFragment(RefineFragment())
                    true
                }
                R.id.explore -> {

                    loadFragment(ExploreFragment())
                    true
                }
                R.id.network -> {
                    loadFragment(NetworkFragment())
                    true
                }

                R.id.chat -> {
                     loadFragment(ChatFragment())
                    true
                }

                R.id.contact -> {
                    loadFragment(ContactFragment())
                    true
                }

                else -> {


                    true
                }
            }
        }

    }


    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}