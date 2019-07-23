package com.example.data.repository

import com.example.data.network.NetworkHelper
import com.example.domain.TasksDataSource
import com.example.domain.repository.PriceRepository
import javax.inject.Inject

class PriceRepositoryImpl : PriceRepository {
/*    @Inject
    lateinit var networkHelper: NetworkHelper*/

    var networkHelper = NetworkHelper()

/*    init {
        MyApplication.getDaggerComponent().injectNetworkHelper(this)
    }*/

    override fun fetchPrice(
        fetchPriceCallback: TasksDataSource.FetchPriceCallback,
        timeSpan: Int
    ) {
        networkHelper.fetchPrice(fetchPriceCallback, timeSpan)
    }
}