package com.example.domain

import com.example.domain.model.Price

interface TasksDataSource {

    interface FetchPriceCallback {
        fun onPriceFetched(values: List<Price>?)
    }

}