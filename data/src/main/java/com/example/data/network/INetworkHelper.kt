package com.example.data.network

import com.example.domain.TasksDataSource

interface INetworkHelper {
    fun fetchPrice(
        fetchPriceCallback: TasksDataSource.FetchPriceCallback,
        time: Int
    )

}
