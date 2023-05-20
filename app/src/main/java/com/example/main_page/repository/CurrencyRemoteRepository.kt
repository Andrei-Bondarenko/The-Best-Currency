package com.example.main_page.repository

import com.example.main_page.api.CurrencyApi
import com.example.main_page.model.CurrencyConverter
import com.example.main_page.model.currency_info.CurrencyInfo
import timber.log.Timber

class CurrencyRemoteRepository (
    private val api: CurrencyApi
    ): CurrencyInfoRepository {


    override suspend fun getCurrencyInfoData(apikey: String): List<CurrencyInfo?> {
        val infoData = api.getCurrencyInfoData(apikey)
        val ratesData = api.getCurrencyRatesData(apikey)
        Timber.d("INFODATA ===== $infoData \n RATESDATA ====$ratesData")
        return CurrencyConverter.fromNetworkInfo(infoData.data,ratesData.data)
    }




}