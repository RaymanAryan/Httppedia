package com.rayman.httppedia.data.model

import androidx.annotation.Keep
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Keep class HttpMethod(val title: String, val headline: String, val description: String)