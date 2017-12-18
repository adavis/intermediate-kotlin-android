package com.example.solarsystem

import android.view.View
import org.jetbrains.anko.*

class PlanetDetailUi : AnkoComponent<PlanetDetailFragment> {
    override fun createView(ui: AnkoContext<PlanetDetailFragment>): View {
        return with(ui) {
            verticalLayout {
                lparams(matchParent)

                textView {
                    setLineSpacing(8f, 1f)
                }.lparams {
                    topMargin = dip(16)
                }

                textView {
                    setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.ic_landscape, 0, 0, 0)
                }

                textView {
                    setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.ic_brightness, 0, 0, 0)
                }

                textView {
                    setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.ic_loop, 0, 0, 0)
                }


            }
        }
    }

}