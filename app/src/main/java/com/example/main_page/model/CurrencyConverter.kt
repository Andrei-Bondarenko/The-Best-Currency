package com.example.main_page.model

import com.example.main_page.api.model.currency_info_data_response.CurrencyInfoDataResponse
import com.example.main_page.api.model.currency_info_data_response.CurrencyInfoResponse
import com.example.main_page.api.model.currency_rates_data_response.CurrencyRatesDataResponse
import com.example.main_page.model.currency_info.CurrencyInfo
import com.example.main_page.model.currency_rates.CurrencyRatesData

object CurrencyConverter {

    fun fromNetworkRates(response: CurrencyRatesDataResponse?): CurrencyRatesData? {
        return response?.let {
            CurrencyRatesData(
                AUD = response.AUD,
                BGN = response.BGN,
                BRL = response.BRL,
                CAD = response.CAD,
                CHF = response.CHF,
                CNY = response.CNY,
                CZK = response.CZK,
                DKK = response.DKK,
                EUR = response.EUR,
                HKD = response.HKD,
                HRK = response.HRK,
                HUF = response.HUF,
                IDR = response.IDR,
                ILS = response.ILS,
                INR = response.INR,
                ISK = response.ISK,
                JPY = response.JPY,
                KRW = response.KRW,
                MXN = response.MXN,
                MYR = response.MYR,
                NOK = response.NOK,
                NZD = response.NZD,
                PHP = response.PHP,
                PLN = response.PLN,
                RON = response.RON,
                RUB = response.RUB,
                SEK = response.SEK,
                SGD = response.SGD,
                THB = response.THB,
                TRY = response.TRY,
                USD = response.USD,
                ZAR = response.ZAR,
            )
        }
    }

    fun fromNetworkInfo(response: CurrencyInfoDataResponse,rateResponse: CurrencyRatesDataResponse): List<CurrencyInfo?> {
        val currencies = mutableListOf<CurrencyInfo?>()
        currencies.add(fromNetwork(response.AUD, rateResponse.AUD))
        currencies.add(fromNetwork(response.BGN, rateResponse.BGN))
        currencies.add(fromNetwork(response.BRL, rateResponse.BRL))
        currencies.add(fromNetwork(response.CAD, rateResponse.CAD))
        currencies.add(fromNetwork(response.CHF, rateResponse.CHF))
        currencies.add(fromNetwork(response.CNY, rateResponse.CNY))
        currencies.add(fromNetwork(response.CZK, rateResponse.CZK))
        currencies.add(fromNetwork(response.DKK, rateResponse.DKK))
        currencies.add(fromNetwork(response.EUR, rateResponse.EUR))
        currencies.add(fromNetwork(response.HKD, rateResponse.HKD))
        currencies.add(fromNetwork(response.HRK, rateResponse.HRK))
        currencies.add(fromNetwork(response.HUF, rateResponse.HUF))
        currencies.add(fromNetwork(response.IDR, rateResponse.IDR))
        currencies.add(fromNetwork(response.ILS, rateResponse.ILS))
        currencies.add(fromNetwork(response.INR, rateResponse.INR))
        currencies.add(fromNetwork(response.ISK, rateResponse.ISK))
        currencies.add(fromNetwork(response.JPY, rateResponse.JPY))
        currencies.add(fromNetwork(response.KRW, rateResponse.KRW))
        currencies.add(fromNetwork(response.MXN, rateResponse.MXN))
        currencies.add(fromNetwork(response.MYR, rateResponse.MYR))
        currencies.add(fromNetwork(response.NOK, rateResponse.NOK))
        currencies.add(fromNetwork(response.NZD, rateResponse.NZD))
        currencies.add(fromNetwork(response.PHP, rateResponse.PHP))
        currencies.add(fromNetwork(response.PLN, rateResponse.PLN))
        currencies.add(fromNetwork(response.RON, rateResponse.RON))
        currencies.add(fromNetwork(response.RUB, rateResponse.RUB))
        currencies.add(fromNetwork(response.SEK, rateResponse.SEK))
        currencies.add(fromNetwork(response.SGD, rateResponse.SGD))
        currencies.add(fromNetwork(response.THB, rateResponse.THB))
        currencies.add(fromNetwork(response.TRY, rateResponse.TRY))
        currencies.add(fromNetwork(response.USD, rateResponse.USD))
        currencies.add(fromNetwork(response.ZAR, rateResponse.ZAR))
        return currencies
    }

    private fun fromNetwork(response: CurrencyInfoResponse?, rate: Double?): CurrencyInfo? {
        return response?.let {
            return CurrencyInfo(
            symbol = response.symbol,
            name = response.name,
            code = response.code,
            name_plural = response.name_plural,
            rate = rate
            )
        }
    }
}