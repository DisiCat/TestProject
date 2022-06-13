package com.example.testproject.parseModels

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class ResultParseModel(
    @Json(name = "status") var status: String? = null,
    @Json(name = "user") var user: UserParseModel? = UserParseModel()
)
