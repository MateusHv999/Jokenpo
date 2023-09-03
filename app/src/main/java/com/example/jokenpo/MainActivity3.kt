package com.example.jokenpo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.jokenpo.databinding.ActivityMain3Binding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity3 : AppCompatActivity() {
    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMain3Binding.inflate(layoutInflater)
        drawer = binding.root
        navDrawer = binding.navView
        bottomNav = binding.bottomNav
        val resultIntent = Intent(this, MainActivity2::class.java)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbarResult)
        setupToolBar()
        setupDrawer()
        setupBottom()
    }

    private fun setupToolBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }

    private fun setupDrawer() {
        val resultIntent = Intent(this, MainActivity3::class.java)
        val playerIntent = Intent(this, MainActivity2::class.java)
        navDrawer.setNavigationItemSelectedListener { menuItem ->
            drawer.closeDrawers()
            when (menuItem.itemId) {
                R.id.player_drawer -> {
                    startActivity(playerIntent)
                    true
                }
                R.id.resultado_drawer -> {
                    startActivity(resultIntent)
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.play_menu, menu)
        return true
    }

    private fun setupBottom() {
        val resultIntent = Intent(this, MainActivity3::class.java)
        val playerIntent = Intent(this, MainActivity2::class.java)
        bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.player_option -> {
                    startActivity(playerIntent)
                    true
                }
                R.id.result_option -> {
                    startActivity(resultIntent)
                    true
                }
                else -> false
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val restartIntent = Intent(this, MainActivity::class.java)
        return when (item.itemId) {
            R.id.restart_option -> {
                startActivity(restartIntent)
                true
            }
            else -> false
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        drawer.openDrawer(GravityCompat.START)
        return true
    }
}
