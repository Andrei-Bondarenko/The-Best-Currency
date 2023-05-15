package com.example.utils.extensions

import com.example.main_page.ui.adapter.EnumWeatherDescriptionType
import com.example.thebestcurrency.R

fun Any.getDrawable(type: String?) =
    when (type) {
        EnumWeatherDescriptionType.AUD.description -> R.drawable.ic_australian_dollar
        EnumWeatherDescriptionType.BGN.description -> R.drawable.ic_bulgarian_lev
        EnumWeatherDescriptionType.BRL.description -> R.drawable.ic_brazilian_reals
        EnumWeatherDescriptionType.CAD.description -> R.drawable.ic_canadian_dollar
        EnumWeatherDescriptionType.CHF.description -> R.drawable.ic_swiss_franc
        EnumWeatherDescriptionType.CNY.description -> R.drawable.ic_chinese_yuan
        EnumWeatherDescriptionType.CZK.description -> R.drawable.ic_czeh_republic_koruna
        EnumWeatherDescriptionType.DKK.description -> R.drawable.ic_danish_krone
        EnumWeatherDescriptionType.EUR.description -> R.drawable.ic_euro
        EnumWeatherDescriptionType.GBR.description -> R.drawable.ic_british_pound_sterling
        EnumWeatherDescriptionType.HKD.description -> R.drawable.ic_hong_kong_dollar
        EnumWeatherDescriptionType.HRK.description -> R.drawable.ic_croatian_cuna
        EnumWeatherDescriptionType.HUF.description -> R.drawable.ic_hungarian_forint
        EnumWeatherDescriptionType.IDR.description -> R.drawable.ic_indonezian_rupiah
        EnumWeatherDescriptionType.ILS.description -> R.drawable.ic_izraeli_new_sheqel
        EnumWeatherDescriptionType.INR.description -> R.drawable.ic_indian_rupee
        EnumWeatherDescriptionType.ISK.description -> R.drawable.ic_icelandic_krona
        EnumWeatherDescriptionType.JPY.description -> R.drawable.ic_japanese_yen
        EnumWeatherDescriptionType.KRW.description -> R.drawable.ic_south_korean_won
        EnumWeatherDescriptionType.MXN.description -> R.drawable.ic_mexican_peco
        EnumWeatherDescriptionType.MYR.description -> R.drawable.ic_malaysian_ringgit
        EnumWeatherDescriptionType.NOK.description -> R.drawable.ic_norwegian_krone
        EnumWeatherDescriptionType.NZD.description -> R.drawable.ic_new_zealand_dollar
        EnumWeatherDescriptionType.PHP.description -> R.drawable.ic_philippine_peso
        EnumWeatherDescriptionType.PLN.description -> R.drawable.ic_polish_zloty
        EnumWeatherDescriptionType.RON.description -> R.drawable.ic_romanian_leu
        EnumWeatherDescriptionType.RUB.description -> R.drawable.ic_russian_ruble
        EnumWeatherDescriptionType.SEK.description -> R.drawable.ic_swedish_krona
        EnumWeatherDescriptionType.SGD.description -> R.drawable.ic_singapore_dollar
        EnumWeatherDescriptionType.THB.description -> R.drawable.ic_thai_baht
        EnumWeatherDescriptionType.TRY.description -> R.drawable.ic_turkish_lira
        EnumWeatherDescriptionType.USD.description -> R.drawable.ic_dollar
        EnumWeatherDescriptionType.ZAR.description -> R.drawable.ic_south_african_rand


        else -> R.drawable.ic_dollar
    }