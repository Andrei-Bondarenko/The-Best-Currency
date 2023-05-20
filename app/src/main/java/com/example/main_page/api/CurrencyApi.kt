package com.example.main_page.api

import com.example.main_page.api.model.currency_info_data_response.CurrencyInfoDataListResponse
import com.example.main_page.api.model.currency_rates_data_response.CurrencyRatesDataListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("v1/currencies")
    suspend fun getCurrencyInfoData(
        @Query("apikey") apikey: String,
    ): CurrencyInfoDataListResponse


    @GET("v1/latest")
    suspend fun getCurrencyRatesData(
        @Query("apikey") apikey: String,
    ): CurrencyRatesDataListResponse

}