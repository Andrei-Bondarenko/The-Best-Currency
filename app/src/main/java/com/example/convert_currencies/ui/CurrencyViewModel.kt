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
            CurrencyEnum.AUD.currencyName -> data?.AUD?.name
            CurrencyEnum.BGN.currencyName -> data?.BGN?.name
            CurrencyEnum.BRL.currencyName -> data?.BRL?.name
            CurrencyEnum.CAD.currencyName -> data?.CAD?.name
            CurrencyEnum.CHF.currencyName -> data?.CHF?.name
            CurrencyEnum.CNY.currencyName -> data?.CNY?.name
            CurrencyEnum.CZK.currencyName -> data?.CZK?.name
            CurrencyEnum.DKK.currencyName -> data?.DKK?.name
            CurrencyEnum.EUR.currencyName -> data?.EUR?.name
            CurrencyEnum.HKD.currencyName -> data?.HKD?.name
            CurrencyEnum.HRK.currencyName -> data?.HRK?.name
            CurrencyEnum.HUF.currencyName -> data?.HUF?.name
            CurrencyEnum.IDR.currencyName -> data?.IDR?.name
            CurrencyEnum.ILS.currencyName -> data?.ILS?.name
            CurrencyEnum.INR.currencyName -> data?.INR?.name
            CurrencyEnum.ISK.currencyName -> data?.ISK?.name
            CurrencyEnum.JPY.currencyName -> data?.JPY?.name
            CurrencyEnum.KRW.currencyName -> data?.KRW?.name
            CurrencyEnum.MXN.currencyName -> data?.MXN?.name
            CurrencyEnum.MYR.currencyName -> data?.MYR?.name
            CurrencyEnum.NOK.currencyName -> data?.NOK?.name
            CurrencyEnum.NZD.currencyName -> data?.NZD?.name
            CurrencyEnum.PHP.currencyName -> data?.PHP?.name
            CurrencyEnum.PLN.currencyName -> data?.PLN?.name
            CurrencyEnum.RON.currencyName -> data?.RON?.name
            CurrencyEnum.RUB.currencyName -> data?.RUB?.name
            CurrencyEnum.SEK.currencyName -> data?.SEK?.name
            CurrencyEnum.SGD.currencyName -> data?.SGD?.name
            CurrencyEnum.THB.currencyName -> data?.THB?.name
            CurrencyEnum.TRY.currencyName -> data?.TRY?.name
            CurrencyEnum.USD.currencyName -> data?.USD?.name
            CurrencyEnum.ZAR.currencyName -> data?.ZAR?.name

            else -> data?.USD?.name

        }

}