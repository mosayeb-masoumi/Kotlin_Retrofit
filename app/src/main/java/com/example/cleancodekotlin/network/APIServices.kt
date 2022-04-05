package com.example.cleancodekotlin.network

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface APIServices {

    @GET("/posts")
    fun getUserList(): Call<JsonArray?>?


    @POST("/api/Authentication/refresh")
    fun refreshToken(): Call<JsonObject?>?





    @POST("/api/Follow/{SeriesId}/follow")
    fun get401List(@Path("SeriesId") seriesId: Int): Call<JsonObject?>?

}