package com.tunnll.tunllmaps

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import org.osmdroid.util.GeoPoint

@RunWith(MockitoJUnitRunner::class)
class MainActivityUnitTest {

    @Mock
    val context = MainActivity()

    @Test
    fun renderLocationIconTest() {
        val icons = context.renderLocationIcon(GeoPoint(0.0, 0.0))
        org.hamcrest.MatcherAssert.assertThat("Current user location indicator should be set", icons.count() > 0)
    }
}