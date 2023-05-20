package com.example.convert_currencies.repository

import com.example.convert_currencies.api.CurrencyApi
import com.example.convert_currencies.model.CurrencyConverter
import com.example.convert_currencies.model.currency_info.CurrencyInfo
import com.example.convert_currencies.model.currency_info.CurrencyInfoData
import com.example.convert_currencies.repository.CurrencyInfoRepository
import timber.log.Timber

class CurrencyRemoteRepository (
    private val api: CurrencyApi
    ): CurrencyInfoRepository {

    override suspend fun getCurrencyConvertInfoData(apikey: String,baseCurrency: String,currencies: String): CurrencyInfoData {
        val infoData = api.getCurrencyInfoData(apikey)
        val ratesData = api.getCurrencyConvertRatesData(apikey,baseCurrency,currencies)
        Timber.d("INFODATA ===== $infoData \n RATESDATA ====$ratesData")
        return CurrencyConverter.fromNetworkInfo(infoData.data,ratesData.data)
    }


}