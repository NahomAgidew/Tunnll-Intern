package com.tunnll.tunllmaps.commons

import android.content.Context
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File

class MapDownloader(context: Context) {

    val mapDirectory = File(Config.mapDirectory)

    var firebaseStorage: FirebaseStorage? = null
    var mapReference: StorageReference? = null

    init {
        FirebaseApp.initializeApp(context)
        createMapDirectory()

        firebaseStorage = FirebaseStorage.getInstance()
        mapReference = firebaseStorage?.reference?.child(Config.mapTileName)
    }

    fun createMapDirectory() {
        if(!mapDirectory.isDirectory && !mapDirectory.exists()) {
            mapDirectory.mkdir()
        }
    }

    fun downloadMap(localMapFileName: String = Config.localMapFileName): Boolean {
        val localMapFile = File(localMapFileName)
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