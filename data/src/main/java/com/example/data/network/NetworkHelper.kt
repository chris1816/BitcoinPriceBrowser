package com.example.data.network


import com.example.data.network.retrofit.RetrofitFactory
import com.example.domain.TasksDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import java.lang.Exception

open class NetworkHelper: INetworkHelper {

/*    @Inject
    lateinit var retrofit: Retrofit*/

    private val retrofit: Retrofit by lazy {
        RetrofitFactory.getInstance()
    }

    private val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    companion object {
        const val TIMESPANMONTH = "1months"
        const val TIMESPANWEEK = "7days"
        const val ROLLINGAVERAGE = "8hours"
        const val FORMAT = "json"
    }

    private var disposable: Disposable? = null

    init {
//        MyApplication.getDaggerComponent().injectRetrofitInstance(this)
    }

    override fun fetchPrice(
        fetchPriceCallback: TasksDataSource.FetchPriceCallback,
        time: Int
    ) {
        val timeSpan = if (time == 0) TIMESPANWEEK else TIMESPANMONTH

        disposable = apiService.fetchPrice(timeSpan, ROLLINGAVERAGE, FORMAT)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({result ->
                try {
                    fetchPriceCallback.onPriceFetched(result.values)
                } catch(e: Exception) {
                    e.printStackTrace()
                }
            }, {
                it.printStackTrace()
            })
    }

}
