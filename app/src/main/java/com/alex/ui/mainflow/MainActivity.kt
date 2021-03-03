package com.alex.ui.mainflow

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.alex.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Setup the navGraph for this activity
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        val inflater = host.navController.navInflater
        val graph = inflater.inflate(R.navigation.main_flow_nav_graph)
        host.navController.graph = graph
    }
}