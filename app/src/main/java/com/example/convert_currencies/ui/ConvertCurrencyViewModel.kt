package com.example.convert_currencies.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.convert_currencies.interactor.CurrencyInteractor
import com.example.convert_currencies.model.currency_info.CurrencyInfoData
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.CancellationException

data class ConvertCurrencyScreenState(
    val baseCurrencySum: Double,
    val secondaryCurrencySum: Double,
    val baseCurrencyName: String,
    val secondaryCurrencyName: String,
)

class ConvertCurrencyViewModel(
    private val interactor: CurrencyInteractor
) : ViewModel() {

    private val _currencyInfoFlow = MutableStateFlow<CurrencyInfoData?>(null)
    val currencyInfoFlow: StateFlow<CurrencyInfoData?>
        get() = _currencyInfoFlow.asStateFlow()

    val screenState: StateFlow<CurrencyInfoData?>
        get() = _currencyInfoFlow.asStateFlow()

    private val _baseCurrency = MutableStateFlow<CurrencyEnum>(CurrencyEnum.AUD)

    private val _secondaryCurrency = MutableStateFlow<CurrencyEnum>(CurrencyEnum.AUD)

    private val _baseCurrencyAmount = MutableStateFlow<Double>(0.0)

    private val _baseCurrencySumState = MutableStateFlow<CurrencySumState>(CurrencySumState.BaseCurrencyDefault)

    private val _secondaryCurrencyAmount = MutableStateFlow<Double>(0.0)

    private val _screenState =
        combine(
            _currencyInfoFlow.filterNotNull(),
            _baseCurrency,
            _baseCurrencyAmount,
            _secondaryCurrency,
            _secondaryCurrencyAmount
        ) { currencyData, basecurrency, baseCurrencyAmount, secondaryCurrency, secondaryCurrencyAmount ->

//            val baseCurrencySum =
//
//            ConvertCurrencyScreenState(
//                baseCurrencyName = basecurrency.getName(currencyData),
//                secondaryCurrencyName = secondaryCurrency.getName(currencyData),
//                baseCurrencySum = baseCurrencyAmount * basecurrency.getRate()
//            )
        }


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

    fun setBaseCurrency(enum: CurrencyEnum?) {
        if (enum == null) return
        _baseCurrency.value = enum
    }

    fun setSecondaryCurrency(enum: CurrencyEnum?) {
        if (enum == null) return
        _secondaryCurrency.value = enum
    }

    fun setBaseCurrencyAmount(baseCurrencyAmount: String) {
        val amount = baseCurrencyAmount.toDoubleOrNull() ?: 0.0
        _baseCurrencyAmount.value = amount
        _baseCurrencySumState.value = CurrencySumState.BaseCurrencyAmountChanged
    }

    fun setSecondaryCurrencyAmount(secondaryCurrencyAmount: String) {
        val amount = secondaryCurrencyAmount.toDoubleOrNull() ?: 0.0
        _secondaryCurrencyAmount.value = amount
    }


//    fun setFirstCurrencyTV(currencyAmount: Double, currencyRate: Double?) =
//        (currencyRate?.let { currencyAmount.div(it) }).toString()
//
//    fun setSecondCurrencyTV(currencyAmount: Double, currencyRate: Double?) =
//        (currencyRate?.let { currencyAmount.times(it) }).toString()


    fun checkEditTexts(firstEditText: String, secondEditText: String): Int {
        if (firstEditText != "1" && secondEditText == "") return 1
        else if (firstEditText == "1" && secondEditText != "") return 2
        else if (firstEditText == "1" && secondEditText == "") return 3
        else return 4
    }





}