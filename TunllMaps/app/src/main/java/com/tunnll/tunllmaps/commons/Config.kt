package com.tunnll.tunllmaps.commons

import android.Manifest
import android.os.Environment

object Config {
    val requiredPermissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
    val permissionRequestCode = 1234
    val minTime: Long = 2000
    val minDistance = 10.0F
    val mapZoomLevel = 15
    val mapTileName = "tiles.zip"
    val mapDirectory = Environment.getExternalStorageDirectory().absolutePath + "/osmdroid"
    val localMapFileName = mapDirectory + "/" + mapTileName

    // val mockLocation = GeoPoint(47.80520393, -122.29407594)
}