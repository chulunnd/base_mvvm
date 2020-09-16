package com.example.core.module

import com.example.core.bus.RxBus
import com.example.core.bus.RxBusImpl
import com.example.core.rx.AppRxSchedulers
import com.example.core.rx.RxSchedulers
import dagger.Module
import dagger.Provides

@Module
class RxModule {
    @Provides
    fun provideRxSchedulers(): RxSchedulers {
        return AppRxSchedulers()
    }

    @Provides
    fun provideRxBus(): RxBus {
        return RxBusImpl()
    }

}