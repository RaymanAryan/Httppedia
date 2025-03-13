package com.rayman.httppedia.data.model

import androidx.annotation.Keep
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Keep data class ApiData(val http_exceptions: List<HttpException>, val http_methods: List<HttpMethod>)
