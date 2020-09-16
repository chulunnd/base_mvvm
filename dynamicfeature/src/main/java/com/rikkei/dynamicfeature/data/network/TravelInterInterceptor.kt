package com.rikkei.dynamicfeature.data.network


import java.io.IOException
import okhttp3.Interceptor
import okhttp3.Response

/**
 * An {@see Interceptor} that adds an auth token to requests if one is provided, otherwise
 * adds a client id.
 */
class TravelInterInterceptor(
) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        return chain.proceed(requestBuilder.build())
    }
}
