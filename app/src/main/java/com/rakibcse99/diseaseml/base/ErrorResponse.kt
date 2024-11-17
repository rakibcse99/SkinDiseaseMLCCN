package com.rakibcse99.diseaseml.base

import com.google.gson.JsonObject


class ErrorResponse(
    var success: Boolean = false,
    var message: String = "",
    var code: Int = 0,
    val error: JsonObject? = null
)
