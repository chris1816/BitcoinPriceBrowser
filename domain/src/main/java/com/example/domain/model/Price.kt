package com.example.domain.model

import com.google.gson.annotations.SerializedName

class Price {

    @field:SerializedName("x")
    var time: String? = null

    @field:SerializedName("y")
    var dailyPrice: String? = null
}