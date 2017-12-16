package com.example.solarsystem

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.support.v4.withArguments
import org.jetbrains.anko.toast

class PlanetDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_detail)

        val toolbar = findViewById<Toolbar>(R.id.detail_toolbar)
        setSupportActionBar(toolbar)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view ->
            snackbar(view, "My message", "Action") {
                toast("inside the action")
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            val fragment = PlanetDetailFragment()
                    .withArguments(ARG_ITEM_ID to intent.getStringExtra(ARG_ITEM_ID))
            supportFragmentManager.beginTransaction()
                    .add(R.id.planet_detail_container, fragment)
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            navigateUpTo(Intent(this, PlanetListActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
