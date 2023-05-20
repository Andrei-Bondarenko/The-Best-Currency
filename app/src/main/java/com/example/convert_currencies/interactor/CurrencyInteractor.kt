package com.example.convert_currencies.interactor

import com.example.convert_currencies.model.currency_info.CurrencyInfo
import com.example.convert_currencies.model.currency_info.CurrencyInfoData
import com.example.convert_currencies.repository.CurrencyInfoRepository

class CurrencyInteractor(
    private val currencyInfoRepository: CurrencyInfoRepository,
) {
    suspend fun getCurrencyConvertInfoData(apikey: String,baseCurrency: String,currencies: String): CurrencyInfoData {
        return currencyInfoRepository.getCurrencyConvertInfoData(apikey,baseCurrency,currencies)
    }
}