package com.example.utils.extensions

import com.example.convert_currencies.model.currency_info.CurrencyInfoData
import com.example.convert_currencies.ui.EnumCurrencyNamesDescriptionType
import com.example.main_page.ui.adapter.EnumCurrencyDescriptionType
import com.example.convert_currencies.ui.EnumCurrencyRatesDescriptionType
import com.example.thebestcurrency.R





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