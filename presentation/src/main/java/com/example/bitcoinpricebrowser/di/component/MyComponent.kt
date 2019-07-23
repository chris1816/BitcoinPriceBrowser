package com.example.bitcoinpricebrowser.di.component

import com.example.bitcoinpricebrowser.di.module.ApiModule
import com.example.bitcoinpricebrowser.viewmodel.MyViewModel
import com.example.data.network.NetworkHelper
import com.example.data.repository.PriceRepositoryImpl
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApiModule::class])
interface MyComponent {

    fun injectRepository(myViewModel: MyViewModel)
    fun injectRetrofitInstance(networkHelper: NetworkHelper)
    fun injectNetworkHelper(repository: PriceRepositoryImpl)
}
