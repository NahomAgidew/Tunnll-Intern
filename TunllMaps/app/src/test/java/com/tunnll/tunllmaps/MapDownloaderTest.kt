package com.tunnll.tunllmaps

import com.tunnll.tunllmaps.commons.MapDownloader
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowEnvironment
import org.junit.Assert.*
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class MapDownloaderTest {

    @Test
    fun testDownloadMap() {
        val mapDownloader = MapDownloader(RuntimeEnvironment.application)

        val path = ShadowEnvironment.getExternalStorageDirectory().absolutePath + "/osmdroid"
        val ret = mapDownloader.downloadMap(path)

        assertTrue(ret)
    }
}
