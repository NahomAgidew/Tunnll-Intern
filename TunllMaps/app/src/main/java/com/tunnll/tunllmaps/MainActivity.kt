package com.tunnll.tunllmaps

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.ActivityCompat.requestPermissions
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.api.IMapController
import org.osmdroid.tileprovider.tilesource.XYTileSource
import org.osmdroid.views.overlay.ItemizedIconOverlay
import org.osmdroid.views.overlay.ItemizedIconOverlay.OnItemGestureListener
import org.osmdroid.views.overlay.ItemizedOverlay
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus
import org.osmdroid.views.overlay.OverlayItem
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay


class MainActivity : AppCompatActivity(), LocationListener {

    val requiredPermissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
    val permissionRequestCode = 1234
    val minTime: Long = 2000
    val minDistance = 10.0F
    val mapZoomLevel = 15

    val mockLocation = GeoPoint(47.80520393, -122.29407594)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupMapUserAgent()

        setContentView(R.layout.activity_main)

        requestLocationPermission()

        setupMap()

        updateMapLocation(mockLocation)

        fab.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))
    }

    override fun onProviderEnabled(p0: String?) = Unit

    override fun onProviderDisabled(p0: String?) = Unit

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) = Unit


    override fun onLocationChanged(location: Location?) {
        var newLocation = GeoPoint(location!!.latitude, location!!.longitude)

        //updateMapLocation(newLocation)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == permissionRequestCode) {
            if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation()
            } else {
                Toast.makeText(this, "You didn't give permission to access device location", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun permissionsGranted(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * @return Unit
     */
    private fun requestLocationPermission() {
        if(!permissionsGranted()) {
            requestPermissions(this, requiredPermissions, permissionRequestCode)
        } else {
            getCurrentLocation()
        }
    }

    @SuppressLint("MissingPermission")
    private fun getCurrentLocation() {
        var locationManager = getSystemService(Context.LOCATION_SERVICE) as? LocationManager
        locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, this)
    }

    /**
     * Set user agent to prevent getting banned from the osm servers.
     * @return Unit
     */
    private fun setupMapUserAgent() {
        val ctx = applicationContext
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
    }

    /**
     * Map initialization.
     * @return Unit
     */
    private fun setupMap() {
        map.setUseDataConnection(false)
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setBuiltInZoomControls(true)
        map.setMultiTouchControls(true)
    }

    /**
     * Sets the zoom level and center of the map.
     * @param currentPos Location Coordinates
     * @return Unit
     */
    private fun updateMapLocation(currentPos: GeoPoint) {
        val mapController = map.controller
        mapController.setZoom(mapZoomLevel)
        mapController.setCenter(currentPos)

        renderLocationIcon(currentPos)
    }

    /**
     * Renders an icon on the given location.
     * @param newLocation Location Coordinates
     * @return Unit
     */
    private fun renderLocationIcon(newLocation: GeoPoint) {
        var items = arrayListOf<OverlayItem>()
        items.add(OverlayItem("", "", newLocation))

        val mOverlay = ItemizedOverlayWithFocus<OverlayItem>(items,
                object : ItemizedIconOverlay.OnItemGestureListener<OverlayItem> {
                    override fun onItemSingleTapUp(index: Int, item: OverlayItem): Boolean {
                        //do something
                        return true
                    }

                    override fun onItemLongPress(index: Int, item: OverlayItem): Boolean {
                        return false
                    }
                }, this)

        map.overlays.clear()
        map.overlays.add(mOverlay)
    }

}
