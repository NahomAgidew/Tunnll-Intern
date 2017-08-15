package com.tunnll.tunllmaps

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.mockito.runners.MockitoJUnitRunner
import org.osmdroid.util.GeoPoint
import org.robolectric.Robolectric

@RunWith(MockitoJUnitRunner::class)
class MainActivityUnitTest {


    @Test
    fun renderLocationIconTest() {
        val mainActivity = Robolectric.setupActivity(MainActivity::class.java)

        val icons = mainActivity.renderLocationIcon(GeoPoint(0.0, 0.0))
        assertTrue("Current user location indicator should be set", icons.count() > 0)
    }
}