package com.rayman.httppedia.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HttpException(val title: String, val headline: String, val description: String)