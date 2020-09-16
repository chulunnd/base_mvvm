package com.rikkei.dynamicfeature.di.module

import com.example.core.scopes.ActivityScope
import com.example.core.utils.Defines
import com.google.gson.GsonBuilder
import com.rikkei.dynamicfeature.data.network.TravelApiInterface
import com.rikkei.dynamicfeature.data.network.TravelInterInterceptor
import com.rikkei.dynamicfeature.utils.StringUtils
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * module khởi tạo đối tượng liên quan đến api.
 */
@Module
class TravelApiModule {
    @Provides
    @ActivityScope
    fun provideApiInterface(
        client: OkHttpClient?,
        rxAdapter: RxJava2CallAdapterFactory?
    ): TravelApiInterface {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val travelInterInterceptor =
            TravelInterInterceptor()

        val gson = GsonBuilder()
            .setLenient()
            .create()
        val retrofit: Retrofit = Retrofit.Builder() // FIXME: comment old host
            //                .baseUrl(BuildConfig.FLAVOR.equals("aic") ? StringUtil.UA : StringUtil.UD)
            .baseUrl(StringUtils.ENDPOINT)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(travelInterInterceptor)
                    .addInterceptor(loggingInterceptor)
                    .connectTimeout(Defines.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(Defines.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(rxAdapter)
            .build()

        return retrofit.create(TravelApiInterface::class.java)
    }
}