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
                val currencyInfoData = interactor.getCurrencyConvertInfoData(apikey,baseCurrency,currencies)
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
}