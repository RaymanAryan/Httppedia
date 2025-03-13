package com.rayman.httppedia.data.model

import androidx.annotation.Keep
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Keep data class HttpException(val title: String, val headline: String, val description: String)