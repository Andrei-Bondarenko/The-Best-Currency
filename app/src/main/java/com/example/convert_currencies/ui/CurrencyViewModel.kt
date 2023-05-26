package com.example.convert_currencies.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.convert_currencies.interactor.CurrencyInteractor
import com.example.convert_currencies.model.currency_info.CurrencyInfoData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.CancellationException

class CurrencyViewModel(
    private val interactor: CurrencyInteractor
) : ViewModel() {

    private val _currencyInfoFlow = MutableStateFlow<CurrencyInfoData?>(null)
    val currencyInfoFlow: StateFlow<CurrencyInfoData?>
        get() = _currencyInfoFlow.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean>
        get() = _isLoading.asStateFlow()


    fun getCurrencyConvertData(apikey: String, baseCurrency: String, currencies: String) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val currencyInfoData =
                    interactor.getCurrencyConvertInfoData(apikey, baseCurrency, currencies)
                _currencyInfoFlow.emit(currencyInfoData)
            } catch (t: Throwable) {
                Timber.e(t.message)
            } catch (e: CancellationException) {
                Timber.e(e.message)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun setFirstCurrencyTV(currencyAmount: Double, currencyRate: Double?) =
        (currencyRate?.let { currencyAmount.div(it) }).toString()
    fun setSecondCurrencyTV(currencyAmount: Double, currencyRate: Double?) =
        (currencyRate?.let { currencyAmount.times(it) }).toString()


    fun checkEditTexts(firstEditText: String, secondEditText: String): Int {
        if (firstEditText != "1" && secondEditText == "") return 1
        else if (firstEditText == "1" && secondEditText != "") return 2
        else if (firstEditText == "1" && secondEditText == "") return 3
        else return 4
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

    fun getName(currencyName: String, data: CurrencyInfoData?) =
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

}