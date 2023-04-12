package com.example.pagination.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale.Builder

class Apiclient {


    companion object {

        val BASE_URL = "https://api.pexels.com/v1/"

        val KEY = "EFjzhdL89ELkCfmGTa4CLiHeXQjydYUGqSZ2K6KlNAWQoCdQQFwrwWjX"

        lateinit var retrofit: Retrofit

        fun getApiClient(): Retrofit {

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }
    }
}