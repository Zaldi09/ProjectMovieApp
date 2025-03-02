package com.uas.efryzaldi.movieapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import com.uas.efryzaldi.movieapps.MovieFragment
import com.uas.efryzaldi.movieapps.R
import com.uas.efryzaldi.movieapps.TVFragment
import com.uas.efryzaldi.movieapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieFragment = MovieFragment()
        val tvFragment = TVFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment (movieFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_movie -> makeCurrentFragment(movieFragment)
                R.id.menu_tv -> makeCurrentFragment(tvFragment)
                R.id.menu_profile -> makeCurrentFragment(profileFragment)
            }

            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }

    }
}