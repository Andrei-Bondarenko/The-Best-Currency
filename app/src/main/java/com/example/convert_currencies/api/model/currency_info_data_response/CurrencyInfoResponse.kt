package com.example.convert_currencies.api.model.currency_info_data_response

import com.google.gson.annotations.SerializedName

data class CurrencyInfoResponse(
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("code")
    val code: String?,
    @SerializedName("name_plural")
    val name_plural: String?,
    @SerializedName("rate")
    val rate: Double?
)
