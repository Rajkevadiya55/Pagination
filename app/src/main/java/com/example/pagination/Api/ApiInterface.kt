package com.example.pagination.Api

import com.example.pagination.Model.SearchWallpaperModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiInterface {

    @GET("search")
    fun getWallpaper(
        @Query("query") query: String,
        @Query("page") page: String,
        @Header("Authorization") auth: String
    ): Call<SearchWallpaperModel>



}