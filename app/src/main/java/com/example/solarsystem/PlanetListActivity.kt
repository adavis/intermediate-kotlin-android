package com.example.solarsystem

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.*
import com.example.solarsystem.dummy.Planet
import com.example.solarsystem.dummy.PlanetsDataProvider
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_planet_list.*
import kotlinx.android.synthetic.main.planet_list.*
import kotlinx.android.synthetic.main.planet_list_content.*
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.info
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.warn

class PlanetListActivity : AppCompatActivity(), AnkoLogger {

    private lateinit var planetsAdapter: PlanetsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_list)

        setSupportActionBar(toolbar)

        getPlanetsTimeConsuming()
    }

    private fun getPlanetsTimeConsuming() {
        launch(UI) {
            info("starting launch on ${Thread.currentThread().name}")

            val planets: Deferred<List<Planet>> = bg {
                info("starting bg on ${Thread.currentThread().name}")
                Thread.sleep(1_000L)
                PlanetsDataProvider.ITEMS
            }

            planetsAdapter = PlanetsAdapter(planets.await())
            planet_list.adapter = planetsAdapter
        }
    }

    //region Planet List Adapter
    inner class PlanetsAdapter internal constructor(
            internal var values: List<Planet>
    ) : RecyclerView.Adapter<PlanetsAdapter.ViewHolder>() {

        private val clickListener = View.OnClickListener { view ->
            val item = view.tag as Planet
            warn { "Clicked on a planet: $item" }
            startActivity<PlanetDetailActivity>(ARG_ITEM_ID to item.id)
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
    //endregion

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_planet_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_filter_none -> {
                planetsAdapter.values = PlanetsDataProvider.ITEMS
                planetsAdapter.notifyDataSetChanged()
                return true
            }

            R.id.action_filter_terrestrial -> {
                planetsAdapter.values = PlanetsDataProvider.ITEMS.filter { it.inner }
                planetsAdapter.notifyDataSetChanged()
                return true
            }

            R.id.action_filter_gas_giants -> {
                planetsAdapter.values = PlanetsDataProvider.ITEMS.filterNot { it.inner }
                planetsAdapter.notifyDataSetChanged()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
