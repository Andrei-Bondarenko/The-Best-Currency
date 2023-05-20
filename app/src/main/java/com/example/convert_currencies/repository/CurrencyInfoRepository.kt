package com.example.convert_currencies.repository

import com.example.convert_currencies.model.currency_info.CurrencyInfoData

interface CurrencyInfoRepository {

    suspend fun getCurrencyConvertInfoData(apikey: String,baseCurrency: String,currencies: String): CurrencyInfoData
}