package com.rayman.httppedia.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HttpMethod(val title: String, val headline: String, val description: String)