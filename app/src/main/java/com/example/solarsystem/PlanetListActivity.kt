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
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_planet_list.*
import kotlinx.android.synthetic.main.planet_list.*
import kotlinx.android.synthetic.main.planet_list_content.*

class PlanetListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_list)

        setSupportActionBar(toolbar)

        setupRecyclerView(planet_list)
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
            holder.planet_name.text = planet.name
            holder.planet_image.setImageResource(planet.imageResourceId)

            holder.itemView.tag = planet
            holder.itemView.setOnClickListener(clickListener)
        }

        override fun getItemCount(): Int = values.size

        inner class ViewHolder(override val containerView: View)
            : RecyclerView.ViewHolder(containerView), LayoutContainer
    }
}
