package com.theworld.androidtemplatewithnavcomponents.network

import com.theworld.androidtemplatewithnavcomponents.data.response.PostOfficeResponseData
import retrofit2.http.GET

interface Api {

    @GET("Vadodara")
    suspend fun fetchPostOffices(): PostOfficeResponseData
}