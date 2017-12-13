package com.example.solarsystem.dummy

import com.example.solarsystem.R
import java.util.ArrayList
import java.util.HashMap

object PlanetsDataProvider {

    //region planet descriptions
    private const val MARS_DESC = """
        Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System after Mercury. In English, Mars carries a name of the Roman god of war, and is often referred to as the "Red Planet" because the reddish iron oxide prevalent on its surface gives it a reddish appearance that is distinctive among the astronomical bodies visible to the naked eye.

        - Wikipedia
        """

    private const val MERCURY_DESC = """
        Mercury is the smallest and innermost planet in the Solar System. Its orbital period around the Sun of 88 days is the shortest of all the planets in the Solar System. It is named after the Roman deity Mercury, the messenger to the gods.

        - Wikipedia
        """

    private const val VENUS_DESC = """
        Venus is the second planet from the Sun, orbiting it every 224.7 Earth days. It has the longest rotation period (243 days) of any planet in the Solar System and rotates in the opposite direction to most other planets. It has no natural satellites. It is named after the Roman goddess of love and beauty.

        - Wikipedia
        """

    private const val EARTH_DESC = """
        Earth is the third planet from the Sun and the only object in the Universe known to harbor life. According to radiometric dating and other sources of evidence, Earth formed over 4 billion years ago.

        - Wikipedia
        """

    private const val JUPITER_DESC = """
        Jupiter is the fifth planet from the Sun and the largest in the Solar System. It is a giant planet with a mass one-thousandth that of the Sun, but two-and-a-half times that of all the other planets in the Solar System combined.

        - Wikipedia
        """

    private const val SATURN_DESC = """
        Saturn is the sixth planet from the Sun and the second-largest in the Solar System, after Jupiter. It is a gas giant with an average radius about nine times that of Earth.

        - Wikipedia
        """

    private const val URANUS_DESC = """
        Uranus is the seventh planet from the Sun. It has the third-largest planetary radius and fourth-largest planetary mass in the Solar System.

        - Wikipedia
        """

    private const val NEPTUNE_DESC = """
        Neptune is the eighth and farthest known planet from the Sun in the Solar System. In the Solar System, it is the fourth-largest planet by diameter, the third-most-massive planet, and the densest giant planet.

        - Wikipedia
        """
    //endregion

    val ITEMS: MutableList<Planet> = ArrayList()

    val ITEM_MAP: MutableMap<String, Planet> = HashMap()

    //region initializer
    init {
        addItem(Planet(name = "Mercury",
                       description = MERCURY_DESC.trimIndent(),
                       imageResourceId = R.drawable.mercury,
                       inner = true,
                       orbitalPeriod = 0.24F))
        addItem(Planet(name = "Venus",
                       description = VENUS_DESC.trimIndent(),
                       imageResourceId = R.drawable.venus,
                       inner = true,
                       orbitalPeriod = 0.615F))
        addItem(Planet(name = "Earth",
                       description = EARTH_DESC.trimIndent(),
                       imageResourceId = R.drawable.earth,
                       inner = true,
                       knownMoons = 1,
                       orbitalPeriod = 1.0F))
        addItem(Planet(name = "Mars",
                       description = MARS_DESC.trimIndent(),
                       imageResourceId = R.drawable.mars,
                       inner = true,
                       knownMoons = 2,
                       orbitalPeriod = 1.880F))
        addItem(Planet(name = "Jupiter",
                       description = JUPITER_DESC.trimIndent(),
                       imageResourceId = R.drawable.jupiter,
                       knownMoons = 69,
                       orbitalPeriod = 11.862F))
        addItem(Planet(name = "Saturn",
                       description = SATURN_DESC.trimIndent(),
                       imageResourceId = R.drawable.saturn,
                       knownMoons = 62,
                       orbitalPeriod = 29.447F))
        addItem(Planet(name = "Uranus",
                       description = URANUS_DESC.trimIndent(),
                       imageResourceId = R.drawable.uranus,
                       knownMoons = 27,
                       orbitalPeriod = 84.016F))
        addItem(Planet(name = "Neptune",
                       description = NEPTUNE_DESC.trimIndent(),
                       imageResourceId = R.drawable.neptune,
                       knownMoons = 14,
                       orbitalPeriod = 164.791F))
    }
    //endregion

    private fun addItem(item: Planet) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

}
