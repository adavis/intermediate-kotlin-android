package com.example.solarsystem

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.solarsystem.dummy.Planet
import com.example.solarsystem.dummy.PlanetsDataProvider

class PlanetListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_list)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.planet_list)
        setupRecyclerView(recyclerView)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = PlanetsAdapter(PlanetsDataProvider.ITEMS)
    }

    inner class PlanetsAdapter internal constructor(
            private val values: List<Planet>
    ) : RecyclerView.Adapter<PlanetsAdapter.ViewHolder>() {

        private val clickListener = View.OnClickListener { view ->
            val item = view.tag as Planet
            val context = view.context
            val intent = Intent(context, PlanetDetailActivity::class.java)
            intent.putExtra(ARG_ITEM_ID, item.id)

            context.startActivity(intent)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.planet_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val planet = values[position]
            holder.nameText.text = planet.name
            holder.imageView.setImageResource(planet.imageResourceId)

            holder.itemView.tag = planet
            holder.itemView.setOnClickListener(clickListener)
        }

        override fun getItemCount(): Int = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val nameText: TextView = view.findViewById(R.id.planet_name)
            val imageView: ImageView = view.findViewById(R.id.planet_image)
        }
    }
}
