package com.aviraj.appoffragmentation.view

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.aviraj.appoffragmentation.R
import com.aviraj.appoffragmentation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // Log.i("singhInUSA" , "onCreate Started")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)  /* making this xml as the above from all */


        // this is the action bar -> top bar
        setSupportActionBar(binding.toolbar)

        // nav controller -> logic for multiple pages
        // Its handling top bar and navigation for fragmentation
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        var count = 0;

        binding.fab.setOnClickListener { view ->
            count = count+1
            Snackbar.make(view, "Count " + count, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onStart(){
        Log.i("SinghInUSA", "onStrart Starting")
        Toast.makeText( this, "onStart", Toast.LENGTH_SHORT).show()
        super.onStart()
    }

    override fun onResume() {
        Log.i("SinghInUSA", "onResume Starting")
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
        super.onResume()
    }

    override fun onPause() {
        Log.i("SinghInUSA", "onPause Starting")
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
        super.onPause()
    }

    override fun onStop() {
        Log.i("SinghInUSA", "onStop Starting")
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("SinghInUSA", "onDestroy Starting")
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
    
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}