package com.example.convert_currencies.model

import com.example.convert_currencies.api.model.currency_info_data_response.CurrencyInfoDataResponse
import com.example.convert_currencies.api.model.currency_info_data_response.CurrencyInfoResponse
import com.example.convert_currencies.api.model.currency_rates_data_response.CurrencyRatesDataResponse
import com.example.convert_currencies.model.currency_info.CurrencyInfo
import com.example.convert_currencies.model.currency_info.CurrencyInfoData
import com.example.convert_currencies.model.currency_rates.CurrencyRatesData

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

    fun fromNetworkInfo(response: CurrencyInfoDataResponse, rateResponse: CurrencyRatesDataResponse): CurrencyInfoData {
        return CurrencyInfoData(
           fromNetwork(response.AUD, rateResponse.AUD),
           fromNetwork(response.BGN, rateResponse.BGN),
           fromNetwork(response.BRL, rateResponse.BRL),
           fromNetwork(response.CAD, rateResponse.CAD),
           fromNetwork(response.CHF, rateResponse.CHF),
           fromNetwork(response.CNY, rateResponse.CNY),
           fromNetwork(response.CZK, rateResponse.CZK),
           fromNetwork(response.DKK, rateResponse.DKK),
           fromNetwork(response.EUR, rateResponse.EUR),
           fromNetwork(response.HKD, rateResponse.HKD),
           fromNetwork(response.HRK, rateResponse.HRK),
           fromNetwork(response.HUF, rateResponse.HUF),
           fromNetwork(response.IDR, rateResponse.IDR),
           fromNetwork(response.ILS, rateResponse.ILS),
           fromNetwork(response.INR, rateResponse.INR),
           fromNetwork(response.ISK, rateResponse.ISK),
           fromNetwork(response.JPY, rateResponse.JPY),
           fromNetwork(response.KRW, rateResponse.KRW),
           fromNetwork(response.MXN, rateResponse.MXN),
           fromNetwork(response.MYR, rateResponse.MYR),
           fromNetwork(response.NOK, rateResponse.NOK),
           fromNetwork(response.NZD, rateResponse.NZD),
           fromNetwork(response.PHP, rateResponse.PHP),
           fromNetwork(response.PLN, rateResponse.PLN),
           fromNetwork(response.RON, rateResponse.RON),
           fromNetwork(response.RUB, rateResponse.RUB),
           fromNetwork(response.SEK, rateResponse.SEK),
           fromNetwork(response.SGD, rateResponse.SGD),
           fromNetwork(response.THB, rateResponse.THB),
           fromNetwork(response.TRY, rateResponse.TRY),
           fromNetwork(response.USD, rateResponse.USD),
           fromNetwork(response.ZAR, rateResponse.ZAR)
            )
    }

    private fun fromNetwork(response: CurrencyInfoResponse?, rate: Double?): CurrencyInfo {
            return CurrencyInfo(
            symbol = response?.symbol,
            name = response?.name,
            code = response?.code,
            name_plural = response?.name_plural,
            rate = rate
            )
    }
}