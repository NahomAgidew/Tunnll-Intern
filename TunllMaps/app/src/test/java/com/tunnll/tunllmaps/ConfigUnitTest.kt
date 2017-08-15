package com.tunnll.tunllmaps

import com.tunnll.tunllmaps.commons.Config
import org.junit.Test

import org.junit.Assert.*

class ConfigUnitTest {

    @Test
    fun testRequiredPermissions() {
        assertNotNull("Ask for run-time permissions", Config.requiredPermissions)
    }

    @Test
    fun testPermissionRequestCode() {
        assertEquals("Permission request code should be 1234", 1234, Config.permissionRequestCode)
    }

    @Test
    fun testMinTimeValue() {
        assertEquals("MinTime should be 2000", 2000, Config.minTime)
    }

    @Test
    fun testMinDistance() {
        assertEquals("MinDistance should be 10.0", 10.0F, Config.minDistance)
    }

    @Test
    fun testMapZoomLevel() {
        assertEquals("MapZoomLevel should be 15", 15, Config.mapZoomLevel)
    }

}