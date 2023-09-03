package com.example.jokenpo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.jokenpo.databinding.ActivityMain2Binding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity2 : AppCompatActivity() {
    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityMain2Binding.inflate(layoutInflater)
        drawer = binding.root
        navDrawer = binding.navView
        bottomNav = binding.bottomNav
        val resultIntent = Intent(this, MainActivity2::class.java)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbarGame)
        setupToolBar()
        setupDrawer()
        setupBottom()

        val spinner: Spinner = binding.spinner
        ArrayAdapter.createFromResource(this, R.array.play_options, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
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
