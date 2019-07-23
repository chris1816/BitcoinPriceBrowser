package com.example.data.network.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



class RetrofitFactory {

    companion object {
        private lateinit var retrofitInstance: Retrofit
        private const val BASE_URL = "https://api.blockchain.info"

        @Synchronized
        fun getInstance(): Retrofit {
            if (!::retrofitInstance.isInitialized) {
                synchronized(RetrofitFactory::class.java) {
                    if (!::retrofitInstance.isInitialized) {
                        retrofitInstance = Retrofit
                            .Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build()
                    }
                }
            }
            return retrofitInstance
        }
    }
}