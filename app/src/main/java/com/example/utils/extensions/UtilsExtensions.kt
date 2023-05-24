package com.example.utils.extensions

import com.example.convert_currencies.model.currency_info.CurrencyInfoData
import com.example.convert_currencies.ui.EnumCurrencyNamesDescriptionType
import com.example.main_page.ui.adapter.EnumCurrencyDescriptionType
import com.example.convert_currencies.ui.EnumCurrencyRatesDescriptionType
import com.example.thebestcurrency.R


fun Any.getName(currencyName: String, data: CurrencyInfoData?) =
    when (currencyName) {
        EnumCurrencyNamesDescriptionType.AUD.currencyName -> data?.AUD?.name
        EnumCurrencyNamesDescriptionType.BGN.currencyName -> data?.BGN?.name
        EnumCurrencyNamesDescriptionType.BRL.currencyName -> data?.BRL?.name
        EnumCurrencyNamesDescriptionType.CAD.currencyName -> data?.CAD?.name
        EnumCurrencyNamesDescriptionType.CHF.currencyName -> data?.CHF?.name
        EnumCurrencyNamesDescriptionType.CNY.currencyName -> data?.CNY?.name
        EnumCurrencyNamesDescriptionType.CZK.currencyName -> data?.CZK?.name
        EnumCurrencyNamesDescriptionType.DKK.currencyName -> data?.DKK?.name
        EnumCurrencyNamesDescriptionType.EUR.currencyName -> data?.EUR?.name
        EnumCurrencyNamesDescriptionType.HKD.currencyName -> data?.HKD?.name
        EnumCurrencyNamesDescriptionType.HRK.currencyName -> data?.HRK?.name
        EnumCurrencyNamesDescriptionType.HUF.currencyName -> data?.HUF?.name
        EnumCurrencyNamesDescriptionType.IDR.currencyName -> data?.IDR?.name
        EnumCurrencyNamesDescriptionType.ILS.currencyName -> data?.ILS?.name
        EnumCurrencyNamesDescriptionType.INR.currencyName -> data?.INR?.name
        EnumCurrencyNamesDescriptionType.ISK.currencyName -> data?.ISK?.name
        EnumCurrencyNamesDescriptionType.JPY.currencyName -> data?.JPY?.name
        EnumCurrencyNamesDescriptionType.KRW.currencyName -> data?.KRW?.name
        EnumCurrencyNamesDescriptionType.MXN.currencyName -> data?.MXN?.name
        EnumCurrencyNamesDescriptionType.MYR.currencyName -> data?.MYR?.name
        EnumCurrencyNamesDescriptionType.NOK.currencyName -> data?.NOK?.name
        EnumCurrencyNamesDescriptionType.NZD.currencyName -> data?.NZD?.name
        EnumCurrencyNamesDescriptionType.PHP.currencyName -> data?.PHP?.name
        EnumCurrencyNamesDescriptionType.PLN.currencyName -> data?.PLN?.name
        EnumCurrencyNamesDescriptionType.RON.currencyName -> data?.RON?.name
        EnumCurrencyNamesDescriptionType.RUB.currencyName -> data?.RUB?.name
        EnumCurrencyNamesDescriptionType.SEK.currencyName -> data?.SEK?.name
        EnumCurrencyNamesDescriptionType.SGD.currencyName -> data?.SGD?.name
        EnumCurrencyNamesDescriptionType.THB.currencyName -> data?.THB?.name
        EnumCurrencyNamesDescriptionType.TRY.currencyName -> data?.TRY?.name
        EnumCurrencyNamesDescriptionType.USD.currencyName -> data?.USD?.name
        EnumCurrencyNamesDescriptionType.ZAR.currencyName -> data?.ZAR?.name

        else -> data?.USD?.name

    }

fun getRate(type: String?, data: CurrencyInfoData?) =
    when (type) {
        EnumCurrencyRatesDescriptionType.AUD.symbol -> data?.AUD?.rate
        EnumCurrencyRatesDescriptionType.BGN.symbol -> data?.BGN?.rate
        EnumCurrencyRatesDescriptionType.BRL.symbol -> data?.BRL?.rate
        EnumCurrencyRatesDescriptionType.CAD.symbol -> data?.CAD?.rate
        EnumCurrencyRatesDescriptionType.CHF.symbol -> data?.CHF?.rate
        EnumCurrencyRatesDescriptionType.CNY.symbol -> data?.CNY?.rate
        EnumCurrencyRatesDescriptionType.CZK.symbol -> data?.CZK?.rate
        EnumCurrencyRatesDescriptionType.DKK.symbol -> data?.DKK?.rate
        EnumCurrencyRatesDescriptionType.EUR.symbol -> data?.EUR?.rate
        EnumCurrencyRatesDescriptionType.HKD.symbol -> data?.HKD?.rate
        EnumCurrencyRatesDescriptionType.HRK.symbol -> data?.HRK?.rate
        EnumCurrencyRatesDescriptionType.HUF.symbol -> data?.HUF?.rate
        EnumCurrencyRatesDescriptionType.IDR.symbol -> data?.IDR?.rate
        EnumCurrencyRatesDescriptionType.ILS.symbol -> data?.ILS?.rate
        EnumCurrencyRatesDescriptionType.INR.symbol -> data?.INR?.rate
        EnumCurrencyRatesDescriptionType.ISK.symbol -> data?.ISK?.rate
        EnumCurrencyRatesDescriptionType.JPY.symbol -> data?.JPY?.rate
        EnumCurrencyRatesDescriptionType.KRW.symbol -> data?.KRW?.rate
        EnumCurrencyRatesDescriptionType.MXN.symbol -> data?.MXN?.rate
        EnumCurrencyRatesDescriptionType.MYR.symbol -> data?.MYR?.rate
        EnumCurrencyRatesDescriptionType.NOK.symbol -> data?.NOK?.rate
        EnumCurrencyRatesDescriptionType.NZD.symbol -> data?.NZD?.rate
        EnumCurrencyRatesDescriptionType.PHP.symbol -> data?.PHP?.rate
        EnumCurrencyRatesDescriptionType.PLN.symbol -> data?.PLN?.rate
        EnumCurrencyRatesDescriptionType.RON.symbol -> data?.RON?.rate
        EnumCurrencyRatesDescriptionType.RUB.symbol -> data?.RUB?.rate
        EnumCurrencyRatesDescriptionType.SEK.symbol -> data?.SEK?.rate
        EnumCurrencyRatesDescriptionType.SGD.symbol -> data?.SGD?.rate
        EnumCurrencyRatesDescriptionType.THB.symbol -> data?.THB?.rate
        EnumCurrencyRatesDescriptionType.TRY.symbol -> data?.TRY?.rate
        EnumCurrencyRatesDescriptionType.USD.symbol -> data?.USD?.rate
        EnumCurrencyRatesDescriptionType.ZAR.symbol -> data?.ZAR?.rate


        else -> data?.USD?.rate
    }


fun Any.getDrawable(type: String?) =
    when (type) {
        EnumCurrencyDescriptionType.AUD.description -> R.drawable.ic_australian_dollar
        EnumCurrencyDescriptionType.BGN.description -> R.drawable.ic_bulgarian_lev
        EnumCurrencyDescriptionType.BRL.description -> R.drawable.ic_brazilian_reals
        EnumCurrencyDescriptionType.CAD.description -> R.drawable.ic_canadian_dollar
        EnumCurrencyDescriptionType.CHF.description -> R.drawable.ic_swiss_franc
        EnumCurrencyDescriptionType.CNY.description -> R.drawable.ic_chinese_yuan
        EnumCurrencyDescriptionType.CZK.description -> R.drawable.ic_czeh_republic_koruna
        EnumCurrencyDescriptionType.DKK.description -> R.drawable.ic_danish_krone
        EnumCurrencyDescriptionType.EUR.description -> R.drawable.ic_euro
        EnumCurrencyDescriptionType.GBR.description -> R.drawable.ic_british_pound_sterling
        EnumCurrencyDescriptionType.HKD.description -> R.drawable.ic_hong_kong_dollar
        EnumCurrencyDescriptionType.HRK.description -> R.drawable.ic_croatian_cuna
        EnumCurrencyDescriptionType.HUF.description -> R.drawable.ic_hungarian_forint
        EnumCurrencyDescriptionType.IDR.description -> R.drawable.ic_indonezian_rupiah
        EnumCurrencyDescriptionType.ILS.description -> R.drawable.ic_izraeli_new_sheqel
        EnumCurrencyDescriptionType.INR.description -> R.drawable.ic_indian_rupee
        EnumCurrencyDescriptionType.ISK.description -> R.drawable.ic_icelandic_krona
        EnumCurrencyDescriptionType.JPY.description -> R.drawable.ic_japanese_yen
        EnumCurrencyDescriptionType.KRW.description -> R.drawable.ic_south_korean_won
        EnumCurrencyDescriptionType.MXN.description -> R.drawable.ic_mexican_peco
        EnumCurrencyDescriptionType.MYR.description -> R.drawable.ic_malaysian_ringgit
        EnumCurrencyDescriptionType.NOK.description -> R.drawable.ic_norwegian_krone
        EnumCurrencyDescriptionType.NZD.description -> R.drawable.ic_new_zealand_dollar
        EnumCurrencyDescriptionType.PHP.description -> R.drawable.ic_philippine_peso
        EnumCurrencyDescriptionType.PLN.description -> R.drawable.ic_polish_zloty
        EnumCurrencyDescriptionType.RON.description -> R.drawable.ic_romanian_leu
        EnumCurrencyDescriptionType.RUB.description -> R.drawable.ic_russian_ruble
        EnumCurrencyDescriptionType.SEK.description -> R.drawable.ic_swedish_krona
        EnumCurrencyDescriptionType.SGD.description -> R.drawable.ic_singapore_dollar
        EnumCurrencyDescriptionType.THB.description -> R.drawable.ic_thai_baht
        EnumCurrencyDescriptionType.TRY.description -> R.drawable.ic_turkish_lira
        EnumCurrencyDescriptionType.USD.description -> R.drawable.ic_dollar
        EnumCurrencyDescriptionType.ZAR.description -> R.drawable.ic_south_african_rand


        else -> R.drawable.ic_dollar
    }