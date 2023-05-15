package com.example.main_page.repository

import com.example.main_page.model.currency_info.CurrencyInfo

interface CurrencyInfoRepository {

    suspend fun getCurrencyInfoData(apikey: String): List<CurrencyInfo?>

}