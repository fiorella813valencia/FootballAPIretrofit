package com.example.footballapiretrofit.network

import com.example.footballapiretrofit.models.ApiResponseHeader
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface TeamService {
    @GET("2")
    fun getTeams(@Header("x-rapidapi-host")host:String,@Header("x-rapidapi-key")apikey:String): Call<ApiResponseHeader>
}