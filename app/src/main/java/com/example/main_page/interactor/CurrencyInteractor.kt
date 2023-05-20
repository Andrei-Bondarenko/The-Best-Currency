package com.example.main_page.interactor

import com.example.main_page.model.currency_info.CurrencyInfo
import com.example.main_page.repository.CurrencyInfoRepository

class CurrencyInteractor(
    private val currencyInfoRepository: CurrencyInfoRepository,
) {
    suspend fun getCurrencyInfoData(apikey: String): List<CurrencyInfo?> {
        return currencyInfoRepository.getCurrencyInfoData(apikey)
    }


}