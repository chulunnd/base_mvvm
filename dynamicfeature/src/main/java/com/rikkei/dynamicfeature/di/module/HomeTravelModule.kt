package com.rikkei.dynamicfeature.di.module

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class HomeTravelModule {
    @Provides
    @Named("name1")
    fun bindName(name: String): String = name
}