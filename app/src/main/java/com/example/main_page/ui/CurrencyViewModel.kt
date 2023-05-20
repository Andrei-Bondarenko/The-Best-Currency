package com.example.main_page.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.main_page.interactor.CurrencyInteractor
import com.example.main_page.model.currency_info.CurrencyInfo
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.CancellationException

class CurrencyViewModel(
    private val interactor: CurrencyInteractor
) : ViewModel() {

    private val _currencyInfoFlow = MutableStateFlow<List<CurrencyInfo?>?>(null)
    val currencyInfoFlow: StateFlow<List<CurrencyInfo?>?>
        get() = _currencyInfoFlow.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean>
        get() = _isLoading.asStateFlow()


    fun getCurrencyData(apikey: String) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val currencyInfoData = interactor.getCurrencyInfoData(apikey)
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