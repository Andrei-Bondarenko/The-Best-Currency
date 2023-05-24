package com.example.convert_currencies.api

import com.example.convert_currencies.api.model.currency_info_data_response.CurrencyInfoDataListResponse
import com.example.convert_currencies.api.model.currency_rates_data_response.CurrencyRatesDataListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyConvertApi {

    @GET("v1/currencies")
    suspend fun getCurrencyConvertInfoData(
        @Query("apikey") apikey: String,
    ): CurrencyInfoDataListResponse

    @GET("v1/latest")
    suspend fun getCurrencyConvertRatesData(
        @Query("apikey") apikey: String,
        @Query("base_currency") base_currency: String,
        @Query("currencies") currencies: String
    ): CurrencyRatesDataListResponse
}