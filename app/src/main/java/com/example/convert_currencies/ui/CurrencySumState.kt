package com.example.convert_currencies.ui

sealed class CurrencySumState {
    object BaseCurrencyAmountChanged: CurrencySumState()
    object SecondaryCurrencyAmountChanged: CurrencySumState()
    object BaseCurrencyDefault: CurrencySumState()
}
