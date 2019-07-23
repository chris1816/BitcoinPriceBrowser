package com.example.bitcoinpricebrowser.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bitcoinpricebrowser.MyApplication
import com.example.data.repository.PriceRepositoryImpl
import com.example.domain.TasksDataSource
import com.example.domain.model.Price
import com.github.mikephil.charting.data.Entry
import java.util.ArrayList
import javax.inject.Inject

class MyViewModel: ViewModel(), TasksDataSource.FetchPriceCallback {

/*    @Inject
    lateinit var repository: PriceRepositoryImpl*/

    val repository = PriceRepositoryImpl()

    private val _prices = MutableLiveData<List<Entry>>()
    val prices: LiveData<List<Entry>>
        get() = _prices

    companion object {
        const val MESSAGEMONTH = "See price in last month"
        const val MESSAGEWEEK = "See price in last week"
        const val CLICK = "click"
    }

    private var fetchTimeSpan = 0
    var message = MESSAGEWEEK

    init {
//        MyApplication.getDaggerComponent().injectRepository(this)
    }

    fun fetchPrice() {
        repository.fetchPrice(this, fetchTimeSpan)
        fetchTimeSpan = if (fetchTimeSpan == 0) 1 else 0
        message = if (message == MESSAGEMONTH) MESSAGEWEEK else MESSAGEMONTH
    }

    override fun onPriceFetched(values: List<Price>?) {
        values?.let {
            val entryList = getData(values)
            _prices.value = entryList
        }
    }

    private fun getData(prices: List<Price>?): List<Entry> {
        val values = ArrayList<Entry>()
        prices?.let { list ->
            for (price in list) {
                price.time?.let {
                    val timeStamp = it.toFloat()
                    price.dailyPrice?.let {price ->
                        values.add(Entry(timeStamp, price.toFloat()))
                    }
                }
            }
        }
        return values
    }
}