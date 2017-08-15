package com.tunnll.tunllmaps

import org.junit.Test

import org.junit.Assert.*

class ConfigUnitTest {

    @Test
    fun requiredPermissionsSet() {
        assertNotNull("Ask for run-time permissions", Config.requiredPermissions)
    }

    @Test
    fun permissionRequestCodeSet() {
        assertEquals("Permission request code should be 1234", 1234, Config.permissionRequestCode)
    }

    @Test
    fun minTimeValueSet() {
        assertEquals("MinTime should be 2000", 2000, Config.minTime)
    }

    @Test
    fun minDistanceSet() {
        assertEquals("MinDistance should be 10.0", 10.0F, Config.minDistance)
    }

    @Test
    fun mapZoomLevelSet() {
        assertEquals("MapZoomLevel should be 15", 15, Config.mapZoomLevel)
    }
}