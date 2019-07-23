package com.example.domain.model

import com.google.gson.annotations.SerializedName

@Suppress("unused")
class Response {

    @field:SerializedName("status")
    var status: String? = null

    @field:SerializedName("name")
    var name: String? = null

    @field:SerializedName("unit")
    var unit: String? = null

    @field:SerializedName("period")
    var period: String? = null

    @field:SerializedName("description")
    var description: String? = null

    @field:SerializedName("values")
    var values: List<Price>? = null


}