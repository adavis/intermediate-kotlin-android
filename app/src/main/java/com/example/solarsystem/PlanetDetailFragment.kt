package com.example.solarsystem

import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.solarsystem.dummy.Planet
import com.example.solarsystem.dummy.PlanetsDataProvider
import com.example.solarsystem.dummy.composition

const val ARG_ITEM_ID = "item_id"

const val TERRESTRIAL = "Terrestrial"
const val GAS_GIANT = "Gas Giant"

class PlanetDetailFragment : Fragment() {

    private lateinit var planetDescription: TextView
    private lateinit var planetComposition: TextView
    private lateinit var planetMoons: TextView
    private lateinit var planetOrbit: TextView

    private var planet: Planet? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.planet_detail, container, false)

        with(view) {
            planetDescription = findViewById(R.id.planet_description)
            planetComposition = findViewById(R.id.planet_composition)
            planetMoons = findViewById(R.id.planet_moons)
            planetOrbit = findViewById(R.id.planet_orbit)
        }

        if (arguments.containsKey(ARG_ITEM_ID)) {
            planet = PlanetsDataProvider.ITEM_MAP[arguments.getString(ARG_ITEM_ID)]
            planet?.let {
                val activity = this.activity
                val appBarLayout = activity.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
                appBarLayout.title = it.name

                val image = activity.findViewById<ImageView>(R.id.image)
                image.setImageResource(it.imageResourceId)
            }
        }

        return view
    }

    override fun onResume() {
        super.onResume()

        planet?.let {
            planetDescription.text = it.description
            planetComposition.text = it.composition
            planetMoons.text = getString(R.string.num_known_moons, it.knownMoons)
            planetOrbit.text = getString(R.string.orbital_period_years, it.orbitalPeriod)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        planet?.let {
            arguments.putString(ARG_ITEM_ID, it.id)
        }
    }

}
