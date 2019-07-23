package com.example.domain.repository

import com.example.domain.TasksDataSource

interface PriceRepository {

    fun fetchPrice(fetchPriceCallback: TasksDataSource.FetchPriceCallback,
                   timeSpan: Int)
}