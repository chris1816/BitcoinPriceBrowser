package com.example.bitcoinpricebrowser.di.module

import com.example.data.repository.PriceRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun getRepository(): PriceRepositoryImpl {
        return PriceRepositoryImpl()
    }

 /*   @Singleton
    @Provides
    fun getNetworkHelper(): NetworkHelper {
        return NetworkHelper()
    }*/
}