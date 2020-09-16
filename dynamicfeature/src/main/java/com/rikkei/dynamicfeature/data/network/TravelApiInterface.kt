package com.rikkei.dynamicfeature.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

/**
 * create interface call server
 */
interface TravelApiInterface {
    @GET("api/v2/comments/{ids}")
    suspend fun getComments(@Path("ids") commentIds: String): Response<List<Objects>>
}