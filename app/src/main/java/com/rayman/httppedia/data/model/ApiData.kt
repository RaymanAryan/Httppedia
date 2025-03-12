package com.rayman.httppedia.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiData(val http_exceptions: List<HttpException>, val http_methods: List<HttpMethod>)
