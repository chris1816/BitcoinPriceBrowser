package com.example.bitcoinpricebrowser.di.component

import com.example.bitcoinpricebrowser.di.module.ApiModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApiModule::class])
interface MyComponent {

/*    fun injectRepository(myViewModel: MyViewModel)
    fun injectRetrofitInstance(networkHelper: NetworkHelper)
    fun injectNetworkHelper(repository: Repository)*/
}
