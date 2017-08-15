package com.tunnll.tunllmaps.commons

import android.util.Log
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File

class MapDownloader {

    val mapDirectory = File(Config.mapDirectory)

    var firebaseStorage: FirebaseStorage? = null
    var mapReference: StorageReference? = null

    init {
        createMapDirectory()

        firebaseStorage = FirebaseStorage.getInstance()
        mapReference = firebaseStorage?.reference?.child(Config.mapTileName)
    }

    fun createMapDirectory() {
        if(!mapDirectory.isDirectory && !mapDirectory.exists()) {
            mapDirectory.mkdir()
        }
    }

    fun downloadMap(): Boolean {
        val localMapFile = File(Config.localMapFileName)
        var ret = false

        if(localMapFile.exists()) {
            ret = true
        }

        val localFile = File.createTempFile("tiles", "zip")

        mapReference?.getFile(localFile)?.addOnSuccessListener{
            ret = true
        }?.addOnFailureListener{
            ret = false
        }

        return ret
    }
}