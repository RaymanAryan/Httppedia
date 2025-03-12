package com.rayman.httppedia.data.repository

import android.content.Context
import com.rayman.httppedia.data.model.ApiData
import com.squareup.moshi.Moshi
import java.io.IOException

class DataRepository(private val context: Context, private val moshi: Moshi) {

    fun loadJsonFromAssets(): ApiData? {
        return try {
            val json = context.assets.open("data.json").bufferedReader().use { it.readText() }
//            val type = Types.newParameterizedType(ApiData::class.java)
            val adapter = moshi.adapter(ApiData::class.java)
            adapter.fromJson(json)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}
