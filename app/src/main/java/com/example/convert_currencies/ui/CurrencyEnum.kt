package com.example.convert_currencies.ui

import com.example.convert_currencies.model.currency_info.CurrencyInfoData

enum class CurrencyEnum(val currencyName: String) {
    AUD("AUD"),
    BGN("BGN"),
    BRL("BRL"),
    CAD("CAD"),
    CHF("CHF"),
    CNY("CNY"),
    CZK("CZK"),
    DKK("DKK"),
    EUR("EUR"),
    HKD("HKD"),
    HRK("HRK"),
    HUF("HUF"),
    IDR("IDR"),
    ILS("ILS"),
    INR("INR"),
    ISK("ISK"),
    JPY("JPY"),
    KRW("KRW"),
    MXN("MXN"),
    MYR("MYR"),
    NOK("NOK"),
    NZD("NZD"),
    PHP("PHP"),
    PLN("PLN"),
    RON("RON"),
    RUB("RUB"),
    SEK("SEK"),
    SGD("SGD"),
    THB("THB"),
    TRY("TRY"),
    USD("USD"),
    ZAR("ZAR");

    fun getName(data: CurrencyInfoData?): String {
        val name =
        when (this) {
            AUD -> data?.AUD?.name
            BGN -> data?.BGN?.name
            BRL -> data?.BRL?.name
            CAD -> data?.CAD?.name
            CHF -> data?.CHF?.name
            CNY -> data?.CNY?.name
            CZK -> data?.CZK?.name
            DKK -> data?.DKK?.name
            EUR -> data?.EUR?.name
            HKD -> data?.HKD?.name
            HRK -> data?.HRK?.name
            HUF -> data?.HUF?.name
            IDR -> data?.IDR?.name
            ILS -> data?.ILS?.name
            INR -> data?.INR?.name
            ISK -> data?.ISK?.name
            JPY -> data?.JPY?.name
            KRW -> data?.KRW?.name
            MXN -> data?.MXN?.name
            MYR -> data?.MYR?.name
            NOK -> data?.NOK?.name
            NZD -> data?.NZD?.name
            PHP -> data?.PHP?.name
            PLN -> data?.PLN?.name
            RON -> data?.RON?.name
            RUB -> data?.RUB?.name
            SEK -> data?.SEK?.name
            SGD -> data?.SGD?.name
            THB -> data?.THB?.name
            TRY -> data?.TRY?.name
            USD -> data?.USD?.name
            ZAR -> data?.ZAR?.name
        }
        return name ?: ""
    }

    fun getRate(data: CurrencyInfoData?): Double {
        val rate = when (this) {
            AUD -> data?.AUD?.rate
            BGN -> data?.BGN?.rate
            BRL -> data?.BRL?.rate
            CAD -> data?.CAD?.rate
            CHF -> data?.CHF?.rate
            CNY -> data?.CNY?.rate
            CZK -> data?.CZK?.rate
            DKK -> data?.DKK?.rate
            EUR -> data?.EUR?.rate
            HKD -> data?.HKD?.rate
            HRK -> data?.HRK?.rate
            HUF -> data?.HUF?.rate
            IDR -> data?.IDR?.rate
            ILS -> data?.ILS?.rate
            INR -> data?.INR?.rate
            ISK -> data?.ISK?.rate
            JPY -> data?.JPY?.rate
            KRW -> data?.KRW?.rate
            MXN -> data?.MXN?.rate
            MYR -> data?.MYR?.rate
            NOK -> data?.NOK?.rate
            NZD -> data?.NZD?.rate
            PHP -> data?.PHP?.rate
            PLN -> data?.PLN?.rate
            RON -> data?.RON?.rate
            RUB -> data?.RUB?.rate
            SEK -> data?.SEK?.rate
            SGD -> data?.SGD?.rate
            THB -> data?.THB?.rate
            TRY -> data?.TRY?.rate
            USD -> data?.USD?.rate
            ZAR -> data?.ZAR?.rate
        }
        return rate ?: 0.0
    }
}